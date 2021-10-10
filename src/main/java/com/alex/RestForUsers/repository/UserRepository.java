package com.alex.RestForUsers.repository;

import com.alex.RestForUsers.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findByUserName(String name);

    User findUserByLogin(String login);

    User deleteUsersByUserName (String name);

    Boolean existsByLogin(String login);
}
