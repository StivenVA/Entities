package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long id;
    private String name;
    private String desc;
    private Float price;
    private Integer qua;
    private String eventId;
    private Boolean state;
    private Integer available;
}
