package com.oniesoft.repository;

import com.oniesoft.model.AdminRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRegisterRepo extends JpaRepository<AdminRegister, Integer> {
    AdminRegister findByEmail(String email);

    AdminRegister findByEmpId(String empId);

    AdminRegister findByEmailAndPassword(String email, String password);

    List<AdminRegister> findAll();

    AdminRegister findByEmailOrMob(String email, String mob);

    void deleteByEmpId(String empId);

    @Query("SELECT p FROM AdminRegister p WHERE " + "p.email LIKE CONCAT('%', :query, '%') " + "OR p.name LIKE CONCAT('%', :query, '%')" + "OR p.mob LIKE CONCAT('%', :query, '%')" + "OR p.empId LIKE CONCAT('%', :query, '%')")
    List<AdminRegister> searchAdminDetails(@Param("query") String query);


}
