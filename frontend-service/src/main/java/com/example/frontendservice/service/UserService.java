package com.example.frontendservice.service;

import com.example.frontendservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User product);
    List<User> getUsers();

    User getUserById(int id);
    String deleteUser(int id);
    List<User> getByKeyword(String keyword);
}
