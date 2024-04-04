package com.oniesoft.repository;

import com.oniesoft.model.FamilyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyDetailsRepo extends JpaRepository <FamilyDetails,String>{
    List<FamilyDetails> findByEmail(String email);
    void deleteByEmail(String email);
    @Query("SELECT p FROM FamilyDetails p WHERE " + "p.email LIKE CONCAT('%', :query, '%') ")
    List<FamilyDetails> searchFamilyDetails(@Param("query") String query);
}
