package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAuthenticationTokenRepo extends JpaRepository<UserAuthenticationToken, Long> {
    UserAuthenticationToken findByUserAuthTokenValue(String tokenValue);
}
