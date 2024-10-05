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
public class AuthUserResponseDTO <T extends UserResponseDTO>{

    private T user;
    private String accessToken;
    private String idToken;

}
