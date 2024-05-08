package com.oniesoft.serviceimpl;

import com.oniesoft.model.AdminRegister;
import com.oniesoft.model.EmployeeCheckList;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.repository.EmployeeCheckListRepo;
import com.oniesoft.service.EmployeeCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeCheckListServiceImpl implements EmployeeCheckListService {
    @Autowired
    private EmployeeCheckListRepo employeeCheckListRepo;
    @Autowired
    private AdminRegisterRepo adminRegisterRepo;
    @Override
    public void addNewBeeCheckList(EmployeeCheckList employeeCheckList) {
        AdminRegister adminRegister=adminRegisterRepo.findByEmpId(employeeCheckList.getEmpId());
        adminRegister.setCheckBox(true);
        adminRegisterRepo.save(adminRegister);
        employeeCheckListRepo.save(employeeCheckList);
    }
    @Override
    public void updateNewBeeCheckList(EmployeeCheckList employeeCheckList) {
        employeeCheckListRepo.save(employeeCheckList);
    }

    @Override
    public List<EmployeeCheckList> getcheckList(String empId) {
        return employeeCheckListRepo.findByEmpId(empId);
    }
}
