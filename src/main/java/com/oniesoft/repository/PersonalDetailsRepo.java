package com.oniesoft.repository;

import com.oniesoft.model.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailsRepo extends JpaRepository<PersonalDetails,Long> {

    PersonalDetails findByEmail(String email);
}
