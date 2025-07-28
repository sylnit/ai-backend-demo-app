package com.sylnit.ai_backend_demo.service;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomer(UUID custId){
        return customerRepository.findById(custId);
    }
}
