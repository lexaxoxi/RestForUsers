package com.alex.RestForUsers.service;

import com.alex.RestForUsers.model.User;

import java.util.List;

public interface UserService {
    User register(User user, List<String> rolesNames);

    List<User> getAll();


    User findByName(String name);

    void delete(String name);

    boolean checkLogin(String login);

    boolean checkPassword(String password);

    User editUser(User user, List<String> roleNames);
}