package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuyCustomerDTO {

    private List<TicketSaleDTO> tickets;
    private double total;
    private CustomerDTO owner;
    private String qr;
    private boolean claim;
    private String reference;
    private String stateBuy;
    private Timestamp date;
    private double serviceFee;
    private PromoterDTO promoter;
    private EventDTO event;

}
