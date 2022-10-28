package com.example.employee.controller;

import com.example.employee.entity.Customer;
import com.example.employee.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/rest")
public class CustomerController {
    CustomerService customerService;


    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllCustomers(){
    return   new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);

    }
    @GetMapping("/allasd")
    public ResponseEntity<List<Customer>> getAllCustomersWithResposeEntity(){

        return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);

    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id) {
        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
          //  Tutorial _tutorial = customerService.save(new Customer(.getTitle(), .getDescription(), false));
            customerService.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer customer) {
        try{
            customerService.delete(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/five")
    public ResponseEntity<List<Customer>> getFiveCustomers(){
        return   new ResponseEntity(customerService.getFirstFiveCustomer(), HttpStatus.OK);

    }


    @GetMapping("/cusfirstname/{firstName}")
    public ResponseEntity<Object> getCustomerbyFirstName(@PathVariable("firstName") String firstName) {


        Optional<List<Customer>> customersbyFirstName = customerService.findCustomersbyFirstName(firstName);
       log.info("size ---"+customersbyFirstName.get().size());
        if (customersbyFirstName.get().isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerService.findCustomersbyFirstName(firstName), HttpStatus.OK);
        }
    }

    @GetMapping("/custsortbyfirstname")
    public ResponseEntity<Object> getCustomerbyFirstNameSorted() {
        Optional<List<Customer>> customers = customerService.findAllSorted();
        if(customers.get().isEmpty()) {
            return new ResponseEntity <>(null, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity <>(customers,HttpStatus.OK);
        }
    }

//    @PostMapping("/update")
//    public ResponseEntity<Customer> update(Customer customer){
//        return  new ResponseEntity<>(customerService.update(customer).get(),HttpStatus.OK);
//    }



}
