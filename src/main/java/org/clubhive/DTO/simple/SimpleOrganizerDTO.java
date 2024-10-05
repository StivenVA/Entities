package org.clubhive.DTO.simple;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.clubhive.DTO.UserResponseDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleOrganizerDTO extends UserResponseDTO {
    private String organizerId;

}