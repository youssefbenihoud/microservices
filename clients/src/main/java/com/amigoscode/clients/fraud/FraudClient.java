package com.amigoscode.clients.fraud;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Alternative ->
//@FeignClient("fraud")

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check")
public interface FraudClient {

    @GetMapping(path = "/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID);

//    @GetMapping("{customerId}")
//    FraudCheckResponse isFraudster(@PathVariable Integer customerId);
}
