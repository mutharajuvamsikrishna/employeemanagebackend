package com.oniesoft.service;

import com.oniesoft.dto.AdminRegisterDto;
import com.oniesoft.model.AdminRegister;

import java.util.List;

public interface RegisterService {

    String sendEmail(String receipent, String subject, String body);
    String generateOTP();
    public AdminRegister saveRegdetails(AdminRegisterDto adminRegisterDto);
    public List<AdminRegister> getAdminRegisters();
public void   setUserDetails(AdminRegisterDto adminRegister);
    public AdminRegisterDto getAdminregister(String mob);
    public void removeAdminRegister(String mob);
    public AdminRegister getRegister(String email);
    public AdminRegister  addEmployeeByAdmin(AdminRegister adminRegister);
}
