package com.oniesoft.controller;

import com.oniesoft.model.EmployeeCheckList;
import com.oniesoft.repository.EmployeeCheckListAdminRepo;
import com.oniesoft.repository.EmployeeCheckListRepo;
import com.oniesoft.serviceimpl.EmployeeCheckListServiceAdminImpl;
import com.oniesoft.serviceimpl.EmployeeCheckListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/checklist/v1")
public class EmployeeCheckListController {
    @Autowired
  private   EmployeeCheckListServiceImpl employeeCheckListService;
    @Autowired
    private EmployeeCheckListServiceAdminImpl employeeCheckListServiceAdmin;
    @Autowired
    private EmployeeCheckListRepo employeeCheckListRepo;
    @Autowired
    private EmployeeCheckListAdminRepo employeeCheckListAdminRepo;
    @PostMapping("/userchecklist-save")
    public ResponseEntity<?> addUserCheckList(@RequestBody EmployeeCheckList employeeCheckList){
     Optional<EmployeeCheckList> employeeCheckList1=   employeeCheckListRepo.findById(employeeCheckList.getEmail());
     if(employeeCheckList1.isEmpty()) {
         employeeCheckListService.addNewBeeCheckList(employeeCheckList);
     }else{

         employeeCheckListService.addNewBeeCheckList(employeeCheckList);
     }
     return ResponseEntity.ok("Details Saved Suceessfully");
    }
    @GetMapping("/userchecklist-get")
    public List<EmployeeCheckList> getUserCheckList(@RequestParam String email){
       return employeeCheckListService.getcheckList(email);
    }
    @PostMapping("/adminchecklist-save")
    public ResponseEntity<?> addAdminCheckList(@RequestBody EmployeeCheckList employeeCheckList){
        Optional<EmployeeCheckList> employeeCheckList1=   employeeCheckListAdminRepo.findById(employeeCheckList.getEmail());
        if(employeeCheckList1.isEmpty()) {
            employeeCheckListServiceAdmin.addNewBeeCheckList(employeeCheckList);
        }else{
            employeeCheckListServiceAdmin.addNewBeeCheckList(employeeCheckList);
        }
        return ResponseEntity.ok("Details Saved Suceessfully");
    }
    @GetMapping("/adminchecklist-get")
    public List<EmployeeCheckList> getAdminCheckList(@RequestParam String email){
        return employeeCheckListServiceAdmin.getcheckList(email);
    }
    @GetMapping("/adminchecklist-getall")
    public List<EmployeeCheckList> getAllAdminCheckList(){
        return employeeCheckListServiceAdmin.getAllCheckList();
    }

}