package com.amigoscode.fraud.controller;

import com.amigoscode.fraud.dto.FraudResponse;
import com.amigoscode.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<FraudResponse> isFraudster(@PathVariable Long customerId) {
        System.out.println("customerId : " + customerId);
//        boolean isFraudster = fraudCheckService.isFraudulentCustomer(customerId);
//        return new ResponseEntity<FraudResponse>(FraudResponse.builder().isFraudster(isFraudster).build() , HttpStatus.OK);
        FraudResponse response = FraudResponse.builder().isFraudster(false).build();
        return new ResponseEntity<FraudResponse>(response , HttpStatus.OK);
    }
}
