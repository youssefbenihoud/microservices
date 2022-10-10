package com.amigoscode.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;

}
