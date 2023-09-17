package com.project.fooddeliveryservice.repository;

import com.project.fooddeliveryservice.data.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(@Param("userId") long userId);

    //    List<Order> findAllByUserIdAndDeliveryTimeIsNotEmpty(@Param("userId") long userId);
    List<Order> findAllByUserIdAndDeliveryTimeIsNotNull(@Param("userId") long userId);
}
