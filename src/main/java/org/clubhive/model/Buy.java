package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buy {

        private Long id;
        private String qr;
        private Boolean state;
        private Customer owner;
        private Promoter idPromoter;
        private String stateBuy;
        private String reference;
        private List<Detail> details;
}
