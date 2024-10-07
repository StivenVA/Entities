package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyDTO {

    private long id;
    private String qr;
    private boolean state;
    private CustomerDTO owner;
    private PromoterDTO idPromoter;
    private String stateBuy;

}
