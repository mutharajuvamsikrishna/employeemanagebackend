package com.oniesoft.repository;

import com.oniesoft.model.AdminCheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCheckListAdminRepo extends JpaRepository<AdminCheckList,Integer> {
    List<AdminCheckList> findByEmpId(String empId);
}
