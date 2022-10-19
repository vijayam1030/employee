package com.example.employee.repository;

import com.example.employee.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public
interface CustomerRepository extends CrudRepository<Customer, Long> {
      List<Customer> findByFirstNameLikeIgnoreCaseAndLastNameNotLikeIgnoreCaseOrderByEmpIdAsc(@Nullable String firstName, String lastName);
//    @Override
//    public <S extends Customer> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends Customer> Iterable<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<Customer> findById(Long aLong) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Long aLong) {
//        return false;
//    }
//
//    @Override
//    public Iterable<Customer> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<Customer> findAllById(Iterable<Long> longs) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Long aLong) {
//
//    }
//
//    @Override
//    public void delete(Customer entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Long> longs) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends Customer> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
}
