package com.oniesoft.repository;

import com.oniesoft.model.EmergencyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyDetailsRepo extends JpaRepository <EmergencyDetails,String>{

    List<EmergencyDetails> findByEmail(String email);
    void deleteByEmail(String email);
    @Query("SELECT p FROM EmergencyDetails p WHERE " + "p.email LIKE CONCAT('%', :query, '%') ")
    List<EmergencyDetails> searchEmergencyDetails(@Param("query") String query);
}
