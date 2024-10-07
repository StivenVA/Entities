package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyDTO {

    private long id;
    private String qr;
    private boolean state;
    private UserResponseDTO owner;
    private PromoterDTO idPromoter;
    private String stateBuy;
    private String reference;
    private List<DetailDTO> details;
}
