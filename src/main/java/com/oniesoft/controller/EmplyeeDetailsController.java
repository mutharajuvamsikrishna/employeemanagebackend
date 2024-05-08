package com.oniesoft.controller;


import com.oniesoft.model.EmployeeDetails;
import com.oniesoft.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeedetails/v1")
public class EmplyeeDetailsController {
    @Autowired
  private   EmployeeDetailsService employeeDetailsService;
    @PostMapping("/employeedetails-save")
    public ResponseEntity<?> saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        employeeDetailsService.addEmployeeDetails(employeeDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
    @GetMapping("/getemployeedetails")
    public List<EmployeeDetails> getEmployeeDetails(@RequestParam String empId){
        return employeeDetailsService.getEmployeeDetails(empId);
    }
    @PutMapping("/employeedetails-update")
    public ResponseEntity<?> updateEmployeeDetails(@RequestBody EmployeeDetails employeeDetails){
        employeeDetailsService.addEmployeeDetails(employeeDetails);
        return ResponseEntity.ok("Details Saved Succesfully");

    }
}
