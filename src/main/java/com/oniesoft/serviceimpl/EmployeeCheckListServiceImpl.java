package com.oniesoft.serviceimpl;

import com.oniesoft.model.EmployeeCheckList;
import com.oniesoft.repository.EmployeeCheckListRepo;
import com.oniesoft.service.EmployeeCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeCheckListServiceImpl implements EmployeeCheckListService {
    @Autowired
    private EmployeeCheckListRepo employeeCheckListRepo;
    @Override
    public void addNewBeeCheckList(EmployeeCheckList employeeCheckList) {
        employeeCheckListRepo.save(employeeCheckList);
    }

    @Override
    public List<EmployeeCheckList> getcheckList(String email) {
        return employeeCheckListRepo.findAll();
    }
}
