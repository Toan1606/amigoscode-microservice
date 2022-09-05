package com.amigoscode.fraud.controller;

import com.amigoscode.clients.dto.FraudResponse;
import com.amigoscode.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudResponse isFraudster(@PathVariable Long customerId) {

        log.info("fraud check request for customer {}", customerId);
        boolean isFraudster = fraudCheckService.isFraudulentCustomer(customerId);
        return FraudResponse.builder().isFraudster(isFraudster).build();
    }
}
