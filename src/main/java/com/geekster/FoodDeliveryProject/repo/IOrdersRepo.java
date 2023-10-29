package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrdersRepo extends JpaRepository<Orders, Long> {
    List<Orders> findByUserUserId(Long userId);
}
