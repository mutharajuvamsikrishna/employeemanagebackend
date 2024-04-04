package com.oniesoft.controller;

import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.RegisterService;
import com.oniesoft.serviceimpl.JwtService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    JwtService jwtService;
    @Value("${frontEnd}")
    String frontendport;
    @Value("${adminemail}")
    private String email;
    @PostMapping("/sendotp")
    public ResponseEntity<String> sendOtp(@RequestBody AdminRegisterDto adminRegisterDto) {
        AdminRegister adminRegister = adminRegisterRepo.findByEmailAndMob(adminRegisterDto.getEmail(), adminRegisterDto.getMob());
        if (adminRegister != null) {
            return ResponseEntity.status(404).body("allready registered");
        }
        registerService.setUserDetails(adminRegisterDto);
        String otp = registerService.generateOTP();
        adminRegisterDto.setOtp(otp);
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

}
