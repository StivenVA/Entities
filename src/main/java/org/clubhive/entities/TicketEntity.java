package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tickets")
public class TicketEntity {

    @Id
    @Column(name = "id_ticket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_ticket")
    private String name;

    @Column(name = "desc_ticket")
    private String desc;

    @Column(name = "price_ticket")
    private Float price;

    @Column(name = "qua_ticket")
    private Integer qua;

    @Column(name = "available_ticket")
    private Integer available;

    @JoinColumn(name = "id_event", nullable = false)
    @ManyToOne
    private EventEntity eventId;

    @Column(name = "state_ticket")
    private boolean state;
}
