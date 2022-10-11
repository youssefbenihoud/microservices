package com.amigoscode.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)

// Alternative -> @FeignCLient("fraud")
public interface FraudClient {

    // @GetMapping(path="api/v1/fraud-check/api/v1/fraud-check/{customerId}")
    // FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID);

    @GetMapping("{customerId}")
    FraudCheckResponse isFraudster(@PathVariable Integer customerId);
}
