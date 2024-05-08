package com.oniesoft.controller;

import com.oniesoft.model.EmergencyDetails;
import com.oniesoft.service.EmergencyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emergencydetails/v1")
public class EmergencyDetailsController {
    @Autowired
    private EmergencyDetailsService emergencyDetailsService;
    @PostMapping("/emergencydetails-save")
    public ResponseEntity<?> saveEmergencyDetails(@RequestBody EmergencyDetails emergencyDetails){
        emergencyDetailsService.addEmergencyDetails(emergencyDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
    @GetMapping("/getemergencydetails")
    public List<EmergencyDetails> getEmergencyDetails(@RequestParam String empId){
        return emergencyDetailsService.getEmergencyDetails(empId);
    }
    @PutMapping("/emergencydetails-update")
    public ResponseEntity<?> updateEmergencyDetails(@RequestBody EmergencyDetails emergencyDetails){
        emergencyDetailsService.addEmergencyDetails(emergencyDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
}
