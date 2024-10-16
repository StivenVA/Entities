package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clubhive.DTO.auth.CustomerResponseDTO;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyDTO {

    private Long id;
    private String qr;
    private Boolean claim;
    private CustomerResponseDTO owner;
    private PromoterDTO idPromoter;
    private String stateBuy;
    private String reference;
    private Double total;
    private List<DetailDTO> details;
    private Timestamp date;
    private double serviceFee;
}
