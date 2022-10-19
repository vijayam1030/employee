package com.example.employee.controller;

import com.example.employee.entity.Customer;
import com.example.employee.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    CustomerService customerService;

    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers(){
    return    customerService.getAllCustomers();

    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getTutorialById(@PathVariable("id") long id) {
        Optional<Customer> tutorialData = customerService.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createTutorial(@RequestBody Customer customer) {
        try {
          //  Tutorial _tutorial = customerService.save(new Customer(.getTitle(), .getDescription(), false));
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
