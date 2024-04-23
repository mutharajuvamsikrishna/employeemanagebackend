package com.oniesoft.serviceimpl;

import com.oniesoft.model.EmployeeCheckList;
import com.oniesoft.repository.EmployeeCheckListAdminRepo;
import com.oniesoft.service.EmployeeCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeCheckListServiceAdminImpl implements EmployeeCheckListService {
    @Autowired
    private EmployeeCheckListAdminRepo employeeCheckListAdminRepo;

    @Override
    public void addNewBeeCheckList(EmployeeCheckList employeeCheckList) {
        employeeCheckListAdminRepo.save(employeeCheckList);
    }

    @Override
    public List<EmployeeCheckList> getcheckList(String email) {
        return employeeCheckListAdminRepo.findAll();
    }
    public List<EmployeeCheckList> getAllCheckList(){
        return employeeCheckListAdminRepo.findAll();
    }
}
