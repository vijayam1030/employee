package com.example.employee.repository;

import com.example.employee.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public
interface CustomerRepository extends JpaRepository<Customer, Long> {
      List<Customer> findByFirstNameLikeIgnoreCaseAndLastNameNotLikeIgnoreCaseOrderByEmpIdAsc(@Nullable String firstName, String lastName);

      List<Customer> findFirst5ByFirstName(String firstName, Sort sort);
      @Query("select t from Customer t where t.firstName = ?1")
      Optional<List<Customer>> findByFirstName(String firstName);

      @Query("update t Customer t set id = ?1 where t.firstName = ?2")
      Optional<Customer> update(Customer customer);
   //   Optional<Customer> updateCustomer(Customer customer);
}
