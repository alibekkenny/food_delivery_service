package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(@Param("id") long id);

    User findByPhone(@Param("phone") String phone);
}
