package com.amigoscode.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository
            extends JpaRepository<Customer, Integer> {
}
