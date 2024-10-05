package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promoter {
    private long id;
    private String code;
    private Long eventId;
}
