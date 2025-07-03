package com.ynova.bets_travel.domain.repositories;

import com.ynova.bets_travel.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface FlyRepository extends JpaRepository<FlyEntity,Long> {

    @Query("select f from fly f where f.price < :price")
    Set<FlyEntity> selectLessPrice(BigDecimal price);

    @Query("select f from fly f where f.price between :min and :max")
    Set<FlyEntity> selectBetweenPrice(BigDecimal max, BigDecimal min);

    @Query("select f from fly f where f.originName = :origen and f.destinyName = :destiny")
    Set<FlyEntity> selectOriginDestinity(String origen, String destiny);

    @Query("select f from fly f  join  fetch f.tickets t where t.id = :id")
    Optional<FlyEntity> findByTicketId (UUID id);
}
