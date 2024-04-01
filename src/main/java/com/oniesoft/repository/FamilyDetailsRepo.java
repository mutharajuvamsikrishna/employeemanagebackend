package com.oniesoft.repository;

import com.oniesoft.model.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyDetailsRepo extends JpaRepository <FamilyDetails,String>{
    List<FamilyDetails> findByEmail(String email);
}
