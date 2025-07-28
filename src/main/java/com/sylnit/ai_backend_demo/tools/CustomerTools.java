package com.sylnit.ai_backend_demo.tools;

import com.sylnit.ai_backend_demo.model.Customer;
import com.sylnit.ai_backend_demo.service.CustomerService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CustomerTools {
    private final CustomerService customerService;

    public CustomerTools(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Tool(description = "Get customer details by customer ID")
    public Customer getCustomerDetails(UUID customerId){
        Optional<Customer> customer = customerService.getCustomer(customerId);
        return customer.orElse(null);
    }
}
