package com.alex.RestForUsers.dto;

import com.alex.RestForUsers.model.Roles;
import org.springframework.stereotype.Service;

@Service
public class RoleMappingService {
    public RolesDTO toRoleDto(Roles roles) {
        return new RolesDTO(roles.getRoleName());
    }
}