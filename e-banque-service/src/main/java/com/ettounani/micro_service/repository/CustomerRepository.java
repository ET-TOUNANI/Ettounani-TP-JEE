package com.ettounani.micro_service.repository;

import com.ettounani.micro_service.entities.Compte;
import com.ettounani.micro_service.entities.Customer;
import com.ettounani.micro_service.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
