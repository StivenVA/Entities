package org.clubhive.DTO.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clubhive.DTO.UserResponseDTO;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO extends UserResponseDTO {

    private long id;
    private String userId;
    private String dni;
    private String phone;
}
