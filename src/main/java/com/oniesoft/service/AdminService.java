package com.oniesoft.service;

import com.oniesoft.model.*;

import java.util.List;

public interface AdminService {
    public List<AdminRegister> getAllAdminRegisters();
    public List<BankDetails> getAllBankDetails();
    public List<EmergencyDetails> getAllEmergencyDetails();
    public List<FamilyDetails> getAllFamilyDetails();
    public List<PersonalDetails> getAllPersonalDetails();
    public List<EmployeeDetails> getAllEmployeeeDetails();
    public String deleteAdminRegister(String email);
    public String deleteBankDetails(String email);
    public String deleteEmergencyDetails(String email);
    public String deleteEmployeeDetails(String email);
    public String deleteFamilyDetails(String email);
    public String deletePersonalDetails(String email);
    public List<AdminRegister> searchAdminRegister(String query);
    public List<BankDetails> searchBankDetails(String query);
    public List<EmergencyDetails> searchEmergencyDetails(String query);
    public List<EmployeeDetails> searchEmployeeDetails(String query);
    public List<FamilyDetails> searchFamilyDetails(String query);
    public List<PersonalDetails> searchPersonalDetails(String query);
}
