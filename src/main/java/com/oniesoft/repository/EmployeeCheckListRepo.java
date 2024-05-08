package com.oniesoft.repository;

import com.oniesoft.model.EmployeeCheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCheckListRepo extends JpaRepository<EmployeeCheckList,String> {

    List<EmployeeCheckList> findByEmpId(String empId);
}
