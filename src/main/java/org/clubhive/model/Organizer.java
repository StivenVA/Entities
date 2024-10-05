package org.clubhive.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organizer extends User{
    private String organizerId;
    private String urlPay;
    private String picture;
}
