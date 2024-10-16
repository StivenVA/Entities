package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buy_ticket")
public class BuyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_buy")
    private long id;

    @Column(name = "qr_buy")
    private String qr;

    @Column(name = "claim_buy")
    private boolean claim;

    @Enumerated(EnumType.STRING)
    @Column(name = "state_buy", nullable = false)
    private BuyTicketStatus stateBuy;

    @JoinColumn(name = "owner_buy")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity owner;

    @JoinColumn(name = "id_promoter")
    @ManyToOne(fetch = FetchType.EAGER)
    private PromoterEntity idPromoter;

    @Column(name = "reference_buy")
    private String reference;

    @Column(name = "total_buy")
    private Double total;

    @Column(name = "date_buy")
    private Timestamp date;

    @Column(name = "service_fee", nullable = false)
    private double serviceFee;
}
