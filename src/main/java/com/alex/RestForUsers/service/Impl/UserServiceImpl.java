package com.alex.RestForUsers.service.Impl;

import com.alex.RestForUsers.model.Roles;
import com.alex.RestForUsers.model.User;
import com.alex.RestForUsers.repository.RoleRepository;
import com.alex.RestForUsers.repository.UserRepository;
import com.alex.RestForUsers.service.UserService;
import com.alex.RestForUsers.service.validator.LoginValidator;
import com.alex.RestForUsers.service.validator.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private LoginValidator loginValidator = new LoginValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    // Все поля обязательны для заполнения
    @Override
    public User register(User user, List<String> roleNames) {

        List<Roles> roles = new ArrayList<>();

        for (int i = 0; i < roleNames.size(); i++) {
            if (roleRepository.existsByRoleName(roleNames.get(i)))
                roles.add(roleRepository.findUserRoleByRoleName(roleNames.get(i)));
            else {
                roles.add(new Roles(roleNames.get(i)));
                roleRepository.save(roles.get(i));
            }
        }

        // Проверяем логин

        if (!checkLogin(user.getLogin()))
            throw new IllegalArgumentException("Введите корректный логин");


        // Проверяем пароль
        if (!checkPassword(user.getPassword()))
            throw new IllegalArgumentException("Введите корректный пароль");

        user.setRoles(roles);
        User newUser = userRepository.save(user);
        return newUser;
    }



    @Override
    public User editUser(User user, List<String> roleNames) {
        List<Roles> roles = new ArrayList<>();

        for (int i = 0; i < roleNames.size(); i++) {
            if (roleRepository.existsByRoleName(roleNames.get(i)))
                roles.add(roleRepository.findUserRoleByRoleName(roleNames.get(i)));
            else {
                roles.add(new Roles(roleNames.get(i)));
                roleRepository.save(roles.get(i));
            }
        }

        User user_old = userRepository.findUserByLogin(user.getLogin());
        try {
            user_old.setRoles(roles);
            user_old.setLogin(user.getLogin());
            user_old.setPassword(user.getPassword());
        } catch (Exception e) {
            throw new IllegalArgumentException("Заполнены не все данные");
        }

        userRepository.save(user_old);

        return user_old;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findByName(String name) {
        User user = null;
        try {
            user = userRepository.findByUserName(name);
        } catch (Exception e) {
            throw new IllegalArgumentException("Данный пользователь не найден");
        }
        return user;
    }

    @Override
    public void delete(String name) {
        try {
            userRepository.deleteUsersByUserName(name);
        } catch (Exception e) {
            throw new IllegalArgumentException("Данный пользователь не найден");
        }
    }

    @Override
    public boolean checkLogin(String login) {
        return loginValidator.validate(login);
    }

    @Override
    public boolean checkPassword(String password) {
        return passwordValidator.validate(password);
    }
}