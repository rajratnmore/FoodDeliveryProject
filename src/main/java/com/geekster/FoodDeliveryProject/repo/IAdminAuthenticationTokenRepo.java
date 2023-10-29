package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.AdminAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminAuthenticationTokenRepo extends JpaRepository<AdminAuthenticationToken, Long> {
    AdminAuthenticationToken findByAdminAuthTokenValue(String tokenValue);
}
