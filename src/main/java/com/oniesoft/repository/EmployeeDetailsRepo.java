package com.oniesoft.repository;

import com.oniesoft.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,Integer> {
List<EmployeeDetails> findByEmpId(String empId);
    void deleteByEmpId(String empId);
    @Query("SELECT p FROM EmployeeDetails p WHERE " + "p.empId LIKE CONCAT('%', :query, '%') ")
    List<EmployeeDetails> searchEmployeeDetails(@Param("query") String query);
}
