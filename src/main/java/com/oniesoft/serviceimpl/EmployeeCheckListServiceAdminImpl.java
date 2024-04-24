package com.oniesoft.serviceimpl;

import com.oniesoft.model.AdminCheckList;
import com.oniesoft.repository.EmployeeCheckListAdminRepo;
import com.oniesoft.service.AdminEmployeeCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeCheckListServiceAdminImpl implements AdminEmployeeCheckListService {
    @Autowired
    private EmployeeCheckListAdminRepo employeeCheckListAdminRepo;

    @Override
    public void addAdminNewBeeCheckList(AdminCheckList adminCheckList) {
        employeeCheckListAdminRepo.save(adminCheckList);
    }

    @Override
    public List<AdminCheckList> getAdmincheckList(String email) {
        return employeeCheckListAdminRepo.findAll();
    }
    public List<AdminCheckList> getAllCheckList(){
        return employeeCheckListAdminRepo.findAll();
    }
}
