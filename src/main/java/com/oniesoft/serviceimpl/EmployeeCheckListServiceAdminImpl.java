package com.oniesoft.serviceimpl;

import com.oniesoft.model.AdminCheckList;
import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.repository.EmployeeCheckListAdminRepo;
import com.oniesoft.service.AdminEmployeeCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeCheckListServiceAdminImpl implements AdminEmployeeCheckListService {
    @Autowired
    private EmployeeCheckListAdminRepo employeeCheckListAdminRepo;
@Autowired
  private  AdminRegisterRepo adminRegisterRepo;
    @Override
    public void addAdminNewBeeCheckList(AdminCheckList adminCheckList) {
        AdminRegister adminRegister=adminRegisterRepo.findByEmpId(adminCheckList.getEmpId());
        adminRegister.setAdminCheckBox(true);
        adminRegisterRepo.save(adminRegister);
        employeeCheckListAdminRepo.save(adminCheckList);
    }

    @Override
    public void upDateAdminNewBeeCheckList(AdminCheckList adminCheckList) {
        List<AdminCheckList> adminCheckList1=employeeCheckListAdminRepo.findByEmpId(adminCheckList.getEmpId());
        employeeCheckListAdminRepo.save(adminCheckList1.get(0));
    }


    @Override
    public List<AdminCheckList> getAdmincheckList(String empId) {
        return employeeCheckListAdminRepo.findByEmpId(empId);
    }
    public List<AdminCheckList> getAllCheckList(){
        return employeeCheckListAdminRepo.findAll();
    }
}
