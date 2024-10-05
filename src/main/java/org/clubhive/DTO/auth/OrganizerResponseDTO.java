package org.clubhive.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clubhive.DTO.UserResponseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerResponseDTO extends UserResponseDTO {
    private long id;
    private String organizerId;
    private String urlPay;
    private String picture;
}
