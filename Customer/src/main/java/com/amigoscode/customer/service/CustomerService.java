package com.amigoscode.customer.service;

import com.amigoscode.clients.FraudClient;
import com.amigoscode.clients.dto.FraudResponse;
import com.amigoscode.customer.dto.CustomerRegistrationRequest;
import com.amigoscode.customer.model.Customer;
import com.amigoscode.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        customer = customerRepository.saveAndFlush(customer);
        // todo: check if fraudster

        FraudResponse response = fraudClient.isFraudster(customer.getId());

        if (response == null || response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
