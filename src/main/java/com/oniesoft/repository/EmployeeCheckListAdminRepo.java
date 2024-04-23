package com.oniesoft.repository;

import com.oniesoft.model.EmployeeCheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCheckListAdminRepo extends JpaRepository<EmployeeCheckList,String> {
}
