package com.ynova.bets_travel.domain.repositories;


import com.ynova.bets_travel.domain.entities.TicketEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TicketRepository extends CrudRepository<TicketEntity, UUID> {
}
