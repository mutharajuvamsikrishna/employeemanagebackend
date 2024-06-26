package com.oniesoft.repository;

import com.oniesoft.model.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Avatar,Long> {
    Avatar findByEmpId(String empId);

    void deleteByEmpId(String empId);
}
