package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "events")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_event")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_orgnz", nullable = false)
    private OrganizerEntity orgnzId;

    @Column(name="name_event")
    private String name;

    @Column(name="desc_event")
    private String desc;

    @Column(name="date_event")
    private LocalDate date;

    @Column(name="time_event")
    private LocalTime time;

    @Column(name = "location")
    private String location;

    @JoinColumn(name="id_city")
    @ManyToOne
    private CityEntity city;

    @Column(name="img_event")
    private String img;

    @Column(name = "state_event")
    private boolean state;

}
