package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "state_buy")
    private boolean state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuyTicketStatus stateBuy;

    @JoinColumn(name = "owner_buy")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity owner;

    @JoinColumn(name = "id_promoter")
    @ManyToOne(fetch = FetchType.EAGER)
    private PromoterEntity idPromoter;

    @Column(name = "reference_buy")
    private String reference;
}
