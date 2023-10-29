package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem, Long> {

}
