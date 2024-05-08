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
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getadmindetails")
    public List<AdminRegister> getAdminDetails(){

       return adminService.getAllAdminRegisters();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getbankdetails")
    public List<BankDetails> getBankDetails(){
        return adminService.getAllBankDetails();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getemergencydetails")
    public List<EmergencyDetails> getEmergencyDetails(){
        return adminService.getAllEmergencyDetails();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getemployeedetails")
    public List<EmployeeDetails> getEmployeeDetails(){
        return adminService.getAllEmployeeeDetails();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getfamilydetails")
    public List<FamilyDetails> getFamilyDetails(){
        return adminService.getAllFamilyDetails();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/getpersonaldetails")
    public List<PersonalDetails> getPersonalDetails(){
        return adminService.getAllPersonalDetails();
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deleteadminregister")
    public ResponseEntity<?> deleteAdminRegister(@RequestParam String empId) {
        String status = adminService.deleteAdminRegister(empId);
        if (status != null) {
          return   ResponseEntity.status(200).body("ok");
        } else {
           return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deletebankdetails")
    public ResponseEntity<?> deleteBank(@RequestParam String empId) {
        String status = adminService.deleteBankDetails(empId);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deleteemergemcydetails")
    public ResponseEntity<?> deleteEmergencyDetails(@RequestParam String empId) {
        String status = adminService.deleteEmergencyDetails(empId);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deleteemployeedetails")
    public ResponseEntity<?> deleteEmployeeDetails(@RequestParam String empId) {
        String status = adminService.deleteEmployeeDetails(empId);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deletefamilydetails")
    public ResponseEntity<?> deleteFamilyDetails(@RequestParam String empId) {
        String status = adminService.deleteFamilyDetails(empId);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @DeleteMapping("/deletepersonaldetails")
    public ResponseEntity<?> deletePersonalDetails(@RequestParam String empId) {
        String status = adminService.deletePersonalDetails(empId);
        if (status != null) {
            return   ResponseEntity.status(200).body("ok");
        } else {
            return ResponseEntity.status(404).body("an unexpected error");
        }
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchadminregister")
    public List<AdminRegister> searchAdminRegister(@RequestParam String query){
      return adminService.searchAdminRegister(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchbankdetails")
    public List<BankDetails> searchBankDetails(@RequestParam String query){
        return adminService.searchBankDetails(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchemergencydetails")
    public List<EmergencyDetails> searchEmergency(@RequestParam String query){
        return adminService.searchEmergencyDetails(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchemployeedetails")
    public List<EmployeeDetails> searchEmployee(@RequestParam String query){
        return adminService.searchEmployeeDetails(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchfamilydetails")
    public List<FamilyDetails> searchFamily(@RequestParam String query){
        return adminService.searchFamilyDetails(query);
    }
   @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_SUPERADMIN')")
    @GetMapping("/searchpersonaldetails")
    public List<PersonalDetails> search(@RequestParam String query){
        return adminService.searchPersonalDetails(query);
    }
}
