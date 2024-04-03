package com.oniesoft.repository;

import com.oniesoft.model.EmergencyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyDetailsRepo extends JpaRepository <EmergencyDetails,String>{

    List<EmergencyDetails> findByEmail(String email);
}