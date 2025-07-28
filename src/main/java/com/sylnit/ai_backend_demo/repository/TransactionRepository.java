package com.sylnit.ai_backend_demo.repository;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

//    @Query(value = "SELECT t from Transaction t where t.customer_id = :customerId ORDER BY t.createdAt DESC LIMIT 5")
//    List<Transaction> getLast5Records(@Param("customerId") UUID customerId);
    List<Transaction> findTop5ByCustomer_IdOrderByCreatedAtDesc(UUID customerId);
}
