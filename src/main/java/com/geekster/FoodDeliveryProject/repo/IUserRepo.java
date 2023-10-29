package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);
}
