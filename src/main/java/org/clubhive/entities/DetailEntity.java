package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailEntity {

    @Id
    @Column(name = "id_details")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @JoinColumn(name = "id_ticket")
    @ManyToOne(fetch = FetchType.EAGER)
    private TicketEntity idTicket;

    @Column(name = "quantity")
    private int quantity;

    @JoinColumn(name = "id_buy")
    @ManyToOne(fetch = FetchType.EAGER)
    private BuyEntity idBuyEntity;
}
