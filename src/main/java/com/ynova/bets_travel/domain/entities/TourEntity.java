package com.ynova.bets_travel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "tour")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "tour"
            ,cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER
            ,orphanRemoval = true
    )
    private Set<ReservationEntity> reservations;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "tour"
            ,cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER
            ,orphanRemoval = true
    )
    private Set<TicketEntity> tickets;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "dni")
    private CustomerEntity customer;
}
