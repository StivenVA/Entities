package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "organizers", uniqueConstraints = @UniqueConstraint(columnNames = {"organizerId", "email"}))
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganizerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String organizerId;
    private String email;
    @Column(nullable = false)
    private String urlPay;
    @Column(name = "name_orgnz", nullable = false)
    private String name;
    private String picture;
}
