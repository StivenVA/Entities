package org.clubhive.DTO.simple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.clubhive.DTO.UserResponseDTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SimpleKeeperDTO extends UserResponseDTO {

    private String keeperId;
    private String phone;
}
