package com.ynova.bets_travel.domain.repositories;

import com.ynova.bets_travel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlyRepository extends JpaRepository<FlyEntity,Long> {
}
