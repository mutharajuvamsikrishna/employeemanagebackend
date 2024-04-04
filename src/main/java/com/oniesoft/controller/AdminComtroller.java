package com.oniesoft.controller;

import com.oniesoft.model.*;
import com.oniesoft.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin/v1")
public class AdminComtroller {
    @Autowired
    private AdminService adminService;
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getadmindetails")
    public List<AdminRegister> getAdminDetails(){
        System.out.println("ok");
       return adminService.getAllAdminRegisters();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getbankdetails")
    public List<BankDetails> getBankDetails(){
        return adminService.getAllBankDetails();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getemergencydetails")
    public List<EmergencyDetails> getEmergencyDetails(){
        return adminService.getAllEmergencyDetails();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getemployeedetails")
    public List<EmployeeDetails> getEmployeeDetails(){
        return adminService.getAllEmployeeeDetails();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getfamilydetails")
    public List<FamilyDetails> getFamilyDetails(){
        return adminService.getAllFamilyDetails();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/getpersonaldetails")
    public List<PersonalDetails> getPersonalDetails(){
        return adminService.getAllPersonalDetails();
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteadminregister")
    public ResponseEntity<?> deleteAdminRegister(@RequestParam String email) {
        String status = adminService.deleteAdminRegister(email);
        if (status != null) {
          return   ResponseEntity.status(200).body("ok");
        } else {
           return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deletebankdetails")
    public ResponseEntity<?> deleteBank(@RequestParam String email) {
        String status = adminService.deleteBankDetails(email);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteemergemcydetails")
    public ResponseEntity<?> deleteEmergencyDetails(@RequestParam String email) {
        String status = adminService.deleteEmergencyDetails(email);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deleteemployeedetails")
    public ResponseEntity<?> deleteEmployeeDetails(@RequestParam String email) {
        String status = adminService.deleteEmployeeDetails(email);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deletefamilydetails")
    public ResponseEntity<?> deleteFamilyDetails(@RequestParam String email) {
        String status = adminService.deleteFamilyDetails(email);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/deletepersonaldetails")
    public ResponseEntity<?> deletePersonalDetails(@RequestParam String email) {
        String status = adminService.deletePersonalDetails(email);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchadminregister")
    public List<AdminRegister> searchAdminRegister(@RequestParam String query){
      return adminService.searchAdminRegister(query);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchbankdetails")
    public List<BankDetails> searchBankDetails(@RequestParam String query){
        return adminService.searchBankDetails(query);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchemergencydetails")
    public List<EmergencyDetails> searchEmergency(@RequestParam String query){
        return adminService.searchEmergencyDetails(query);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchemployeedetails")
    public List<EmployeeDetails> searchEmployee(@RequestParam String query){
        return adminService.searchEmployeeDetails(query);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchfamilydetails")
    public List<FamilyDetails> searchFamily(@RequestParam String query){
        return adminService.searchFamilyDetails(query);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/searchpersonaldetails")
    public List<PersonalDetails> search(@RequestParam String query){
        return adminService.searchPersonalDetails(query);
    }
}
