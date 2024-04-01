package com.oniesoft.service;

import com.oniesoft.dto.AdminRegisterDto;

public interface ForgetAccount {
    public boolean getForgetedOTP(AdminRegisterDto adminRegister);
    public  boolean verifyForgetOtp(AdminRegisterDto adminRegister);
}
