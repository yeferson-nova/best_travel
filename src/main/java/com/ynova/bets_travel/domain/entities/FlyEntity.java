package com.ynova.bets_travel.domain.entities;

import com.ynova.bets_travel.util.AeroLine;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity(name = "fly")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FlyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double originLat;
    private Double originLng;
    private Double destinyLat;
    private Double destinyLng;
    @Column(length = 20)
    private String originName;
    @Column(length = 20)
    private  String destinyName;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private AeroLine aeroLine;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "fly"
            ,cascade = CascadeType.ALL
            ,fetch = FetchType.EAGER
            ,orphanRemoval = true
    )
    private Set<TicketEntity> tickets;

}
