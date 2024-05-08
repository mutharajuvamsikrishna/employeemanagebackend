package com.oniesoft.serviceimpl;

import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.ForgetAccount;
import com.oniesoft.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ForgetAccountImpl implements ForgetAccount {
    @Autowired
    AdminRegisterRepo adminRegisterRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RegisterService registerService;
    @Value("${adminemail}")
    private String adminEmail;
    @Override
    public boolean getForgetedOTP(AdminRegisterDto adminRegister) {
        AdminRegister adminRegister1=adminRegisterRepo.findByEmailOrMob(adminRegister.getEmail(),adminRegister.getMob());
        if(adminRegister1!=null){
            String subject="ONiE Soft ";
          String otp=  registerService.generateOTP();
          adminRegister.setOtp(otp);
         registerService.setUserDetails(adminRegister);
            String body = "Hello " + adminRegister1.getName() + " Your OTP for EmployeeManagement Forgett Acoount is " + "\n" + otp;
            if(adminRegister1.getEmail()!="") {
                registerService.sendEmail(adminRegister1.getEmail(), subject, body);
            }else {
                registerService.sendEmail(adminEmail, subject, body);
            }
return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean verifyForgetOtp(AdminRegisterDto adminRegister) {
        AdminRegisterDto adminRegister1 = registerService.getAdminregister(adminRegister.getMob());
        if (adminRegister1.getOtp().equals(adminRegister.getOtp())) {
          AdminRegister adminRegister2=  adminRegisterRepo.findByEmail(adminRegister1.getEmail());
            adminRegister2.setPassword(passwordEncoder.encode(adminRegister.getPassword()));
            adminRegisterRepo.save(adminRegister2);
registerService.removeAdminRegister(adminRegister.getMob());
            return true;
        } else {
            return false;
        }
    }
}
