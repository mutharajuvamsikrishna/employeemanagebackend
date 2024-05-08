package com.oniesoft.controller;

import com.oniesoft.model.FamilyDetails;
import com.oniesoft.service.FamilyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/familydetails/v1")
public class FamilyDetailsController {
    @Autowired
    private FamilyDetailsService familyDetailsService;
    @PostMapping("/familydetails-save")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody FamilyDetails familyDetails){
        familyDetailsService.addFamilyDetails(familyDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
    @GetMapping("/getfamilydetails")
    public List<FamilyDetails> getEmployeeDetails(@RequestParam String empId){
        return familyDetailsService.getFamilyDetails(empId);
    }
    @PutMapping("/familydetails-update")
    public ResponseEntity<?> updateEmployeeDetails(@RequestBody FamilyDetails familyDetails){
        familyDetailsService.addFamilyDetails(familyDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
}
