package com.example.employee.repository;

import com.example.employee.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRegistrationRepository extends JpaRepository<Customer, Long> {
}
