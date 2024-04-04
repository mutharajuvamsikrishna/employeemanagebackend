package com.oniesoft.repository;

import com.oniesoft.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailsRepo extends JpaRepository<BankDetails, Long> {
    BankDetails findByEmail(String email);

    void deleteByEmail(String email);

    @Query("SELECT p FROM BankDetails p WHERE " + "p.email LIKE CONCAT('%', :query, '%') "
            + "OR p.name LIKE CONCAT('%', :query, '%')" + "OR p.accountNumber LIKE CONCAT('%', :query, '%')")
    List<BankDetails> searchBankDetails(@Param("query") String query);
}
