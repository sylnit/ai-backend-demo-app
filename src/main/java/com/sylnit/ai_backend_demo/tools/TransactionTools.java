package com.sylnit.ai_backend_demo.tools;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.model.Transaction;
import com.sylnit.ai_backend_demo.service.CustomerService;
import com.sylnit.ai_backend_demo.service.TransactionService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class TransactionTools {

    private final CustomerService customerService;
    private final TransactionService transactionService;

    public TransactionTools(CustomerService customerService, TransactionService transactionService) {
        this.customerService = customerService;
        this.transactionService = transactionService;
    }

    @Tool(description = "Get the last 5 transactions by customer ID")
    List<Transaction> getLast5Transactions(UUID customerId){
        Optional<Customer> customer = customerService.getCustomer(customerId);
        return customer.map(transactionService::getLast5).orElse(null);
    }
}
