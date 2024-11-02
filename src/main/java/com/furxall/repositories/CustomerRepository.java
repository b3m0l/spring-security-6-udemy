package com.furxall.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.furxall.entities.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, BigInteger>{
	Optional <CustomerEntity> findByEmail(String email);
}
