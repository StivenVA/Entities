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
    @Column(name = "id_buy")
    long id;

    @Column(name = "qr_buy")
    String qr;

    @Column(name = "state_buy")
    boolean state;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BuyTicketStatus stateBuy;

    @JoinColumn(name = "owner_buy")
    @ManyToOne(fetch = FetchType.EAGER)
    UserEntity owner;

    @JoinColumn(name = "id_promoter")
    @ManyToOne(fetch = FetchType.EAGER)
    PromoterEntity idPromoter;
}
