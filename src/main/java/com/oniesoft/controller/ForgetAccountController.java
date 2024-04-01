package com.oniesoft.controller;

import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.service.ForgetAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/forgetaccount/v1")
public class ForgetAccountController {
    @Autowired
    ForgetAccount forgetAccount;
    @PostMapping("/forgetaccount")
    public ResponseEntity<?> forgetAccount(@RequestBody AdminRegisterDto adminRegister) {
        boolean flag = forgetAccount.getForgetedOTP(adminRegister);
        if (flag) {
            return ResponseEntity.ok("ok");
        } else {
            return ResponseEntity.status(404).body("Data not Match");
        }
    }
    @PutMapping("/verifyforgetotp")
    public ResponseEntity<?> verifyForgetOtp(@RequestBody AdminRegisterDto adminRegister){
      boolean flag=    forgetAccount.verifyForgetOtp(adminRegister);
      if(flag){
          return ResponseEntity.ok("ok");
      }else{
          return  ResponseEntity.status(404).body("unexpected error");
      }
        }
}
