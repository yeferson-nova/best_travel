package com.ynova.bets_travel.domain.repositories;


import com.ynova.bets_travel.domain.entities.TourEntity;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<TourEntity,Long> {
}
