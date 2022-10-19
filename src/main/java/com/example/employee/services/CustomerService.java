package com.example.employee.services;

import com.example.employee.entity.Customer;
import com.example.employee.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {


    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers(){
        return (List<Customer>) repository.findAll();

    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public void save(Customer customer) {
        repository.save(customer);
    }
}
