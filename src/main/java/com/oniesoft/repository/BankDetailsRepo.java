package com.oniesoft.repository;

import com.oniesoft.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankDetailsRepo extends JpaRepository<BankDetails, Long> {
    BankDetails findByEmpId(String empId);

    void deleteByEmpId(String empId);

    @Query("SELECT p FROM BankDetails p WHERE " + "p.empId LIKE CONCAT('%', :query, '%') "
            + "OR p.name LIKE CONCAT('%', :query, '%')" + "OR p.accountNumber LIKE CONCAT('%', :query, '%')")
    List<BankDetails> searchBankDetails(@Param("query") String query);
}
