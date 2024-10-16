package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buy {

        private Long id;
        private String qr;
        private Boolean claim;
        private Customer owner;
        private Promoter idPromoter;
        private String stateBuy;
        private String reference;
        private List<Detail> details;
        private Double total;
        private Timestamp date;
        private double ServiceFee;
}
