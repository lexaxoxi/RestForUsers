package com.alex.RestForUsers.repository;

import com.alex.RestForUsers.model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Roles, Integer> {
    Roles findUserRoleByRoleId(int id);
    Roles findUserRoleByRoleName(String name);
    Boolean existsByRoleName(String name);
}
