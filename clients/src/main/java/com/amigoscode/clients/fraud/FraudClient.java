package com.amigoscode.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)

// Alternative -> @FeignCLient("fraud")
public interface FraudClient {

    // @GetMapping(path="api/v1/fraud-check/api/v1/fraud-check/{customerId}")
    // FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID);
    // You need to take FraudCheckResponse File into this package ..clients.fraud
}
