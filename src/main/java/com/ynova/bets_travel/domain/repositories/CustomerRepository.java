package com.ynova.bets_travel.domain.repositories;

import com.ynova.bets_travel.domain.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,String> {
}
