package com.oniesoft.repository;

import com.oniesoft.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails,Long> {

    PersonalDetails findByEmpId(String empId);
    void deleteByEmpId(String empId);
    @Query("SELECT p FROM PersonalDetails p WHERE " + "p.empId LIKE CONCAT('%', :query, '%') ")
    List<PersonalDetails> searchPersonalDetails(@Param("query") String query);
}
