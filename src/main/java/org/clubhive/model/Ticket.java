package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {

    private Long id;
    private String name;
    private String desc;
    private Float price;
    private int qua;
    private String idEvent;
    private Boolean state;
    private Integer available;
}
