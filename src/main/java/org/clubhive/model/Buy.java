package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buy {

        private long id;
        private String qr;
        private boolean state;
        private Customer owner;
        private Promoter idPromoter;
}
