package org.clubhive.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KeeperDTO extends UserAuthentication{
    private long id;
    private String phone;
    private String name;
    private long organizerId;
}
