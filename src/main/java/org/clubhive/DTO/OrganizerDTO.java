package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerDTO extends UserAuthentication{
    private long id;
    private String name;
    private String urlPay;
    private String picture;
}
