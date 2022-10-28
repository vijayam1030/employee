package com.example.employee.services;

import com.example.employee.entity.Customer;
import com.example.employee.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerService {


    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customerList= repository.findAll();
        log.info("Getting all customers"+customerList);
        return customerList;

    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public Customer save(Customer customer) {

        log.info(String.valueOf(customer));
        return repository.save(customer);
    }

    public void delete(Customer customer) {
         repository.delete(customer);
    }

    public List<Customer> getFirstFiveCustomer(){
        Sort sort = Sort.by("firstName").ascending();
   //     Sort sorting = Sort.by()
       return repository.findFirst5ByFirstName("harry",sort);
    }


    public Optional<List<Customer>> findCustomersbyFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    public Optional<List<Customer>> findAllwithExample(Customer customer) {
        Example<Customer> example = Example.of(new Customer(1L,"testname", "test"));
        //ExampleMatcher
        //Example<Customer> example1 = Example.of(customer1);

        return Optional.of(repository.findAll(example));
    }

    public Optional<List<Customer>> findAllSorted(){
        Example<Customer> example = Example.of(new Customer(1l, "bloggs", "test"));
       return Optional.of(repository.findAll(example,Sort.by(Sort.Direction.ASC, "firstName")));

    }

//    public Optional<Customer> update(Customer customer){
//        return repository.update(customer);
//    }



//    public void givenPassengers_whenFindByExample_thenExpectedReturned() {
//        Example<Customer> example = Example.of(new Customer(1l, "Bloggs", "test"));
//
//        Optional<Passenger> actual = repository.findOne(example);
//
//        assertTrue(actual.isPresent());
//        assertEquals(Passenger.from("Fred", "Bloggs", 22), actual.get());
//    }
//
//
//    public void givenPassengers_whenFindByExampleCaseInsensitiveMatcher_thenExpectedReturned() {
//        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
//
//        Example<Customer> example = Example.of(Customer.from("fred", "bloggs", null),
//                caseInsensitiveExampleMatcher);
//
//        Optional<Customer> actual = repository.findOne(example);
//
//
//    }
}
