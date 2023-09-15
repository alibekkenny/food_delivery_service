package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    Food findById(@Param("id") long id);
}
