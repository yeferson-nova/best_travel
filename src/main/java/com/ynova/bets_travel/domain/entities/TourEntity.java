package com.ynova.bets_travel.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

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

    public void addTicket(TicketEntity ticket){
        if (Objects.isNull(this.tickets)) this.tickets = new HashSet<>();
        this.tickets.add(ticket);
    }
    public void removeTicket(UUID id){
        this.tickets.removeIf(ticket ->  ticket.getId().equals(id));
    }

    public void updateTicket(){
        this.tickets.forEach(ticket -> ticket.setTour(this));
    }

    public void addReservation(ReservationEntity reservation){
        this.reservations.add(reservation);
    }
    public void removeReservation(UUID id){
        if (Objects.isNull(this.reservations)) this.reservations = new HashSet<>();
        this.reservations.removeIf(reservations -> reservations.getId().equals(id));
    }
    public void updateReservation(){
        this.reservations.forEach(reservation -> reservation.setTour(this));
    }
}
