package com.amigoscode.clients;

import com.amigoscode.clients.dto.FraudResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudResponse isFraudster(@PathVariable Long customerId);
}
