package com.oniesoft.service;

import com.oniesoft.model.EmployeeDetails;

import java.util.List;

public interface EmployeeDetailsService {
    public void addEmployeeDetails(EmployeeDetails employeeDetails);
    public List<EmployeeDetails> getEmployeeDetails(String empId);
}
