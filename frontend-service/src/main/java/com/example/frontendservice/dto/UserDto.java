package com.example.frontendservice.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idUser;


        private String name;

        private String email;


        private String username;


        private String password;

        private String phone;




    }
