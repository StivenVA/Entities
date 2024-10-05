package org.clubhive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Long id;

    private String name;

    private String desc;

    private String date;

    private String time;

    private long cityId;

    private String location;

    private String img;

    private String orgnzId;

    private Boolean state;

    private String orgnzName;

    private List<Promoter> promoters;

    private List<Ticket> tickets;
}
