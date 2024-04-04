package com.oniesoft.serviceimpl;

import com.oniesoft.model.*;
import com.oniesoft.repository.*;
import com.oniesoft.service.AdminService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private PersonalDetailsRepo personalDetailsRepo;
    @Autowired
    private EmployeeDetailsRepo employeeDetailsRepo;
    @Autowired
    private BankDetailsRepo bankDetailsRepo;
    @Autowired
    private FamilyDetailsRepo familyDetailsRepo;
    @Autowired
    private AdminRegisterRepo adminRegisterRepo;
    @Autowired
    EmergencyDetailsRepo emergencyDetailsRepo;
    @Override
    public List<AdminRegister> getAllAdminRegisters(){
    return adminRegisterRepo.findAll();
    }
    @Override
    public List<BankDetails> getAllBankDetails(){
        return bankDetailsRepo.findAll();
    }
    @Override
    public List<EmergencyDetails> getAllEmergencyDetails(){
        return emergencyDetailsRepo.findAll();
    }
    @Override
    public List<EmployeeDetails> getAllEmployeeeDetails(){
        return employeeDetailsRepo.findAll();
    }
    @Override
    public List<FamilyDetails> getAllFamilyDetails(){
        return familyDetailsRepo.findAll();
    }
    @Override
    public List<PersonalDetails> getAllPersonalDetails(){
        return personalDetailsRepo.findAll();
    }
    @Override
    @Transactional
    public String deleteAdminRegister(String email){
        adminRegisterRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    @Transactional
    public String deleteBankDetails(String email){
        bankDetailsRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    @Transactional
    public String deleteEmergencyDetails(String email){
        emergencyDetailsRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    @Transactional
    public String deleteEmployeeDetails(String email){
        employeeDetailsRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    @Transactional
    public String deleteFamilyDetails(String email){
        familyDetailsRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    @Transactional
    public String deletePersonalDetails(String email){
        personalDetailsRepo.deleteByEmail(email);
        return "deleted";
    }
    @Override
    public List<AdminRegister> searchAdminRegister(String query) {
        List<AdminRegister> adminRegisters = adminRegisterRepo.searchAdminDetails(query);
        return adminRegisters;
    }

    @Override
    public List<BankDetails> searchBankDetails(String query) {
        List<BankDetails> bankDetails = bankDetailsRepo.searchBankDetails(query);
        return bankDetails;
    }

    @Override
    public List<EmergencyDetails> searchEmergencyDetails(String query) {
        List<EmergencyDetails> emergencyDetails=emergencyDetailsRepo.searchEmergencyDetails(query);
        return emergencyDetails;
    }

    @Override
    public List<EmployeeDetails> searchEmployeeDetails(String query) {
      List<EmployeeDetails> employeeDetails=employeeDetailsRepo.searchEmployeeDetails(query);
      return employeeDetails;
    }

    @Override
    public List<FamilyDetails> searchFamilyDetails(String query) {
     List<FamilyDetails> familyDetails=familyDetailsRepo.searchFamilyDetails(query);
     return familyDetails;
    }

    @Override
    public List<PersonalDetails> searchPersonalDetails(String query) {
        List<PersonalDetails> personalDetails=personalDetailsRepo.searchPersonalDetails(query);
        return personalDetails;
    }
}
