package com.oniesoft.repository;

import com.oniesoft.model.EmployeeCheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCheckListRepo extends JpaRepository<EmployeeCheckList,String> {

}
