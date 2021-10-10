package com.alex.RestForUsers.dto;

import com.alex.RestForUsers.model.User;

import java.util.List;

public class RolesDTO {
    private User user;
    private List<String> roles;

    public RolesDTO(String roleName) {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
