package com.alex.RestForUsers.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @Column(name = "user_login")
    private String login;

    @Column(name = "user_name")
    private String userName;


    @Column(name = "user_password")
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_name", referencedColumnName = "user_name")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<Roles> roles;

    public User(String login, String userName, String password) {
        this.password = password;
        this.login = login;
        this.userName = userName;

    }

    public User() {

    }

    public String getUserName() {
        return this.userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName=" + userName +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

