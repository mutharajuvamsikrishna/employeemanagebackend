package com.oniesoft.repository;

import com.oniesoft.model.RaiseDispute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RaiseDisputeRepo extends JpaRepository<RaiseDispute,Integer> {
    @Query("SELECT p FROM RaiseDispute p WHERE " +
            "p.email LIKE CONCAT('%', :query, '%') OR " +
            "p.regno LIKE CONCAT('%', :query, '%')")
    List<RaiseDispute> searchRaiseDispute(@Param("query") String query);

    List<RaiseDispute> findByEmail(String email);

}
