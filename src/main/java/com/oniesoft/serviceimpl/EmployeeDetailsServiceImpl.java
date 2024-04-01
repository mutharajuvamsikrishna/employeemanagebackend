package com.oniesoft.serviceimpl;

import com.oniesoft.model.EmployeeDetails;
import com.oniesoft.repository.EmployeeDetailsRepo;
import com.oniesoft.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
    @Autowired
    private EmployeeDetailsRepo employeeDetailsRepo;
    @Override
    public void addEmployeeDetails(EmployeeDetails employeeDetails) {
        System.out.println(employeeDetails);
       EmployeeDetails employeeDetails1= employeeDetailsRepo.save(employeeDetails);
    }

    @Override
    public List<EmployeeDetails> getEmployeeDetails(String email) {
        return employeeDetailsRepo.findByEmail(email);
    }
    }
