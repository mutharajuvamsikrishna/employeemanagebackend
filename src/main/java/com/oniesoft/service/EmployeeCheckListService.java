package com.oniesoft.service;

import com.oniesoft.model.EmployeeCheckList;

import java.util.List;

public interface EmployeeCheckListService {
    public void addNewBeeCheckList(EmployeeCheckList employeeCheckList);
    public List<EmployeeCheckList> getcheckList(String email);
}
