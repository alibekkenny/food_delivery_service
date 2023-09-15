package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
}
