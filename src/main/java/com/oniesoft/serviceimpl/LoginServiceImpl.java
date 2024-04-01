package com.oniesoft.serviceimpl;

import com.oniesoft.model.AdminRegister;
import com.oniesoft.repository.AdminRegisterRepo;
import com.oniesoft.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AdminRegisterRepo adminRegisterRepo;


    @Override
    public AdminRegister login(AdminRegister adminRegister) {

        AdminRegister adminRegister1=adminRegisterRepo.findByEmailAndPassword(adminRegister.getEmail(),adminRegister.getPassword());
        if(adminRegister1!=null){

            return adminRegister1;
        }else {
          return null;
        }
    }
}
