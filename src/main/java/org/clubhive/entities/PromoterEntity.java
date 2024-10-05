package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "promoters",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"code", "id_event"})})
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoterEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_promoter")
        private Long id;

        @Column(name = "code_promoter", nullable = false, unique = true)
        private String code;

        @ManyToOne
        @JoinColumn(name = "id_event")
        private EventEntity eventId;
}
