package com.oniesoft.controller;

import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.RegisterService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/register/v1")
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @Autowired
    AdminRegisterRepo adminRegisterRepo;
    @Value("${superadminemail}")
    private String superAdminEmail;
    @Value("${superadminpassword}")
    private String superAdminPassword;
    @Value("${superadminmob}")
    private String superAdminMob;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/sendotp")
    public ResponseEntity<String> sendOtp(@RequestBody AdminRegisterDto adminRegisterDto) {
        AdminRegister adminRegister = adminRegisterRepo.findByEmailAndMob(adminRegisterDto.getEmail(), adminRegisterDto.getMob());
        if (adminRegister != null) {
            return ResponseEntity.status(404).body("allready registered");
        }
        String otp = registerService.generateOTP();
        adminRegisterDto.setOtp(otp);
        registerService.setUserDetails(adminRegisterDto);
        String subject = "EmployeeManagement OTP";
        String body = "Hello " + adminRegisterDto.getName() + " Your OTP for EmployeeManagement Registration is " + "\n" + otp;
        registerService.sendEmail(adminRegisterDto.getEmail(), subject, body);
        return ResponseEntity.ok("otpsent sucessfully");
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<?> veriftOtp(@RequestBody AdminRegisterDto adminRegisterDto, HttpSession httpSession) {
        AdminRegister adminRegister = registerService.saveRegdetails(adminRegisterDto);

        if (adminRegister != null) {

            return ResponseEntity.ok("details saved sucessfully");
        } else {
            return ResponseEntity.status(404).body("Invalid OTP");
        }
    }


    @GetMapping("/getallreg")
    public ArrayList<AdminRegister> getAllAdminRegs() {
        List<AdminRegister> regList = registerService.getAdminRegisters();
        return new ArrayList<>(regList);
    }
    @GetMapping("/getreg")
    public AdminRegister getAdminRegister(@RequestParam String email){
        return registerService.getRegister(email);
    }
    @PostConstruct
    public void addSuperAdmin(){
        AdminRegister adminRegister=new AdminRegister();
        adminRegister.setRoles("ROLE_SUPERADMIN");
        adminRegister.setEmail(superAdminEmail);
        adminRegister.setPassword(passwordEncoder.encode(superAdminPassword));
        adminRegister.setName("ONiE Soft");
        adminRegister.setMob(superAdminMob);
    AdminRegister adminRegister1=    adminRegisterRepo.findByEmail(superAdminEmail);
    if(adminRegister1==null) {
        adminRegisterRepo.save(adminRegister);
    }
    }
    @PostMapping("/addemployee")
public ResponseEntity<?> addEmployeeByAdmin(@RequestBody AdminRegister adminRegister){
      AdminRegister adminRegister1=  registerService.addEmployeeByAdmin(adminRegister);
      if(adminRegister1!=null) {
          return ResponseEntity.ok("Details Saved Success Fully");
      }else {
return ResponseEntity.status(420).body("Internal Error");
      }
}
}