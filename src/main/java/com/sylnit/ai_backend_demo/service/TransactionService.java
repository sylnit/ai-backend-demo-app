package com.sylnit.ai_backend_demo.service;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.model.Transaction;
import com.sylnit.ai_backend_demo.repository.CustomerRepository;
import com.sylnit.ai_backend_demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getLast5(Customer customer){
//        return transactionRepository.getLast5Records(customer.getId());
        return transactionRepository.findTop5ByCustomer_IdOrderByCreatedAtDesc(customer.getId());
    }
}
