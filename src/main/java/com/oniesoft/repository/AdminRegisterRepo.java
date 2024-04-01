package com.oniesoft.repository;

import com.oniesoft.model.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRegisterRepo extends JpaRepository<AdminRegister,Integer> {
    AdminRegister findByEmail(String email);

    AdminRegister findByEmailAndPassword(String email, String password);
    
    List<AdminRegister> findAll();

    AdminRegister findByEmailAndMob(String email, String mob);
}
