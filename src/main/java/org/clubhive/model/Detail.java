package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detail {

    Long id;
    Ticket idTicket;
    int quantity;
    Buy idBuy;
}
