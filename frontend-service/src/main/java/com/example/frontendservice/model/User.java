package com.example.frontendservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name="name")
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
    @Column(name="phone")
    private String phone;




}
