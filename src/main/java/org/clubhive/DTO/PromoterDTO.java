package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoterDTO {
    private Long id;
    private String code;
    private Long eventId;
}
