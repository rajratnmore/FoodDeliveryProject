package com.geekster.FoodDeliveryProject.repo;

import com.geekster.FoodDeliveryProject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Long> {
    Admin findByAdminEmail(String adminEmail);
}
