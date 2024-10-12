package org.clubhive.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = {"id_user","dni_user","email_user","phone_user","userId"}))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @Column(name="id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "dni_user",nullable = false)
    private String dni;
    @Column(name = "name_user",nullable = false)
    private String name;
    @Column(name = "email_user",nullable = false)
    private String email;
    @Column(name = "phone_user",nullable = false)
    private String phone;
    @Column(name = "userId",nullable = false)
    private String userId;
}
