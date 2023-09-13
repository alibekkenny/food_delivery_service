package com.project.fooddeliveryservice.service;

import com.project.fooddeliveryservice.data.Role;
import com.project.fooddeliveryservice.repository.RoleRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepo;

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public List<Role> getRolesByName(String name) {
        return roleRepo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Role getRoleById(long id) {
        return roleRepo.findById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role updateRole(long id, Role role) {
        Role foundRole = roleRepo.findById(id);
        if (!Objects.equals(role.getName(), "")) {
            foundRole.setName(foundRole.getName());
        }
        return roleRepo.save(foundRole);
    }

    @Override
    public void deleteRoleById(long id) {
        roleRepo.deleteById(id);
    }
}
