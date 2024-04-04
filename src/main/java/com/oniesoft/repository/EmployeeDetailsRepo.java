package com.oniesoft.repository;

import com.oniesoft.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepo extends JpaRepository<EmployeeDetails,Integer> {
List<EmployeeDetails> findByEmail(String email);
    void deleteByEmail(String email);
    @Query("SELECT p FROM EmployeeDetails p WHERE " + "p.email LIKE CONCAT('%', :query, '%') ")
    List<EmployeeDetails> searchEmployeeDetails(@Param("query") String query);
}
