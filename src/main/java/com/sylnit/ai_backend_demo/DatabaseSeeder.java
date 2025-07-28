package com.sylnit.ai_backend_demo;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.model.Transaction;
import com.sylnit.ai_backend_demo.repository.CustomerRepository;
import com.sylnit.ai_backend_demo.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final TransactionRepository  transactionRepository;

    public DatabaseSeeder(CustomerRepository customerRepository, TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i = 1; i <= 5; i++){
            Customer customer = new Customer();
            customer.setName("Customer"+i);
            customer.setEmail("customer"+i+"@example.com");

            Customer savedCustomer = customerRepository.save(customer);
            System.out.println(customer.getId());

            for(int j = 0; j < 5; j++){
                Transaction transaction = new Transaction();
                transaction.setAmount(BigDecimal.valueOf(new Random().nextDouble(10000 - 1000 + 1)+1000));
                transaction.setCreatedAt(Instant.now());
                transaction.setCustomer(savedCustomer);
                transactionRepository.save(transaction);
            }

        }
    }
}
