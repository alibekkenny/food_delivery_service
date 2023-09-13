package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByNameContainingIgnoreCase(@Param("name") String name);

    Role findById(@Param("id") long id);

}
