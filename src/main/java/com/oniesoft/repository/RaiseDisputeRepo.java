package com.oniesoft.repository;

import com.oniesoft.model.RaiseDispute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RaiseDisputeRepo extends JpaRepository<RaiseDispute,Integer> {
    List<RaiseDispute> findByEmail(String email);
}
