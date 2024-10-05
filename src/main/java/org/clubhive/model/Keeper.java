package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Keeper extends User{

    private String keeperId;
    private String phone;
    private long organizerId;

}
