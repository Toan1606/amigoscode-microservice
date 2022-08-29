package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRegistrationRequest;
import com.amigoscode.customer.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public void registerCustomer(CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();
    }
}
