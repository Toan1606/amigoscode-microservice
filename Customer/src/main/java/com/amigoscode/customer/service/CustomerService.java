package com.amigoscode.customer.service;

import com.amigoscode.customer.dto.CustomerRegistrationRequest;
import com.amigoscode.customer.dto.FraudResponse;
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

    public void registerCustomer(CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);
        // todo: check if fraudster
        System.out.println("BEGIN");
        FraudResponse response = restTemplate.getForObject("http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudResponse.class,
                customer.getId()
        );
        System.out.println("END");
        System.out.println("response : " + response);

        if (response.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
