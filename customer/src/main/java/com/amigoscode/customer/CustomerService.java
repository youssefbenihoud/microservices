package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRespository customerRespository;

    public void registerCustomer(CustomerRegistrationRequest registrationRequest){
        Customer customer = Customer.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .build();

        //todo: check if email valid
        //todo: check if email not taken
        //todo: store customer in database
        customerRespository.save(customer);
    }
}
