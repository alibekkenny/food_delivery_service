package com.project.fooddeliveryservice.controller;

import com.project.fooddeliveryservice.data.Role;
import com.project.fooddeliveryservice.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("roles")
@RequiredArgsConstructor
public class RoleController {
    private final IRoleService roleService;

    @PostMapping("/")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

//    @PutMapping("/")
//    public Role updateRole(@RequestBody Role role) {
//        return roleService.updateRole(role);
//    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable long id) {
        roleService.deleteRoleById(id);
        return "Role with successfully deleted!";
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable long id) {
        return roleService.getRoleById(id);
    }
}
