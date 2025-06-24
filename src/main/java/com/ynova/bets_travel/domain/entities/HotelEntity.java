package com.ynova.bets_travel.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String address;
    private int rating;
    private BigDecimal price;

}
