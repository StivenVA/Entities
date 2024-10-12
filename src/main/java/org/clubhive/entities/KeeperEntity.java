package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "keepers", uniqueConstraints = @UniqueConstraint(columnNames = {"keeperId", "email", "phone"}))
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class KeeperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String keeperId;
    private String email;
    private String name;
    private String phone;
    @ManyToOne(fetch = FetchType.EAGER)
    private OrganizerEntity organizer;
}
