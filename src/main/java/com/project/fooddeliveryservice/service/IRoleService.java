package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Role;

import java.util.List;

public interface IRoleService {
    List<Role> getAllRoles();

    List<Role> getRolesByName(String name);

    Role getRoleById(long id);

    Role createRole(Role role);

    Role updateRole(long id, Role role);

    void deleteRoleById(long id);
}
