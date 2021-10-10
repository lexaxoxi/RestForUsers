package com.alex.RestForUsers.controller;

import com.alex.RestForUsers.dto.RolesDTO;
import com.alex.RestForUsers.model.Roles;
import com.alex.RestForUsers.model.User;
import com.alex.RestForUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Получить список пользователей без ролей
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public String getAllUsers(){
        List<User> users = userService.getAll();
        return users.toString();
    }

    // Регистрация нового пользователя
    @RequestMapping(value = "/setNewUser", method = RequestMethod.POST)
    public String  setNewUser(@RequestBody RolesDTO userRoleDTO){
        User user = userRoleDTO.getUser();
        List<String> userRole = userRoleDTO.getRoles();

        try {
            userService.register(user, userRole);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "{success: false, errors: {Invalid login or password}}";
        }

        return "{success: true}\n" + " New user added\n" + user.toString();
    }

    // Получение конкретного пользователя с ролями
    @RequestMapping(value= "/findUserByName", method = RequestMethod.GET)
    public String getUser(@RequestBody String userName){
        User user;
        try {
            user = userService.findByName(userName);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "Not found user";
        }
        List<Roles> roles = user.getRoles();
        return user.toString() + "\nRoles: " + roles.toString();
    }

    // Удаление пользователя
    @RequestMapping(value= "/deleteUserByName", method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody String userName) {
        try {
            userService.delete(userName);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "Not found user, cant delete user";
        }
        return "User was deleted";
    }

    // Редактирование пользователя
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(@RequestBody RolesDTO userRoleDTO){

        User user = userRoleDTO.getUser();
        List<String> userRole = userRoleDTO.getRoles();

        try {
            userService.editUser(user,userRole);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return "Get more information about user";
        }

        return "User edited\n" + user.toString();
    }

}
