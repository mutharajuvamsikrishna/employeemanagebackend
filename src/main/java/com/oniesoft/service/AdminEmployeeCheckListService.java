package com.oniesoft.service;

import com.oniesoft.model.AdminCheckList;

import java.util.List;

public interface AdminEmployeeCheckListService {

    public void addAdminNewBeeCheckList(AdminCheckList employeeCheckList);
    public void upDateAdminNewBeeCheckList(AdminCheckList adminCheckList);
    public List<AdminCheckList> getAdmincheckList(String email);
}
