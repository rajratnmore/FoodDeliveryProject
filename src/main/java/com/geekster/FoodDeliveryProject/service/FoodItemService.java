package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.FoodItem;
import com.geekster.FoodDeliveryProject.model.dto.AdminAuthenticationDto;
import com.geekster.FoodDeliveryProject.model.dto.AuthorizedAdminDto;
import com.geekster.FoodDeliveryProject.model.dto.FoodItemDto;
import com.geekster.FoodDeliveryProject.repo.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    AdminAuthenticationTokenService adminAuthenticationTokenService;

    public String addFoodItem(AuthorizedAdminDto authorizedAdminDto) {
        AdminAuthenticationDto adminAuthenticationDto = authorizedAdminDto.getAdminAuthenticationDto();
        if(adminAuthenticationTokenService.isAuthenticate(adminAuthenticationDto)){
            FoodItemDto foodItemDto = authorizedAdminDto.getFoodItemDto();
            FoodItem newFoodItem = new FoodItem(foodItemDto);
            foodItemRepo.save(newFoodItem);
            return "new Food Item added";
        }else{
            return "Unauthenticated access !";
        }
    }

    public String updateFoodItem(AuthorizedAdminDto authorizedAdminDto) {
        AdminAuthenticationDto adminAuthenticationDto = authorizedAdminDto.getAdminAuthenticationDto();
        if(adminAuthenticationTokenService.isAuthenticate(adminAuthenticationDto)){
            FoodItemDto updatedFoodItemDto = authorizedAdminDto.getFoodItemDto();
            if(foodItemRepo.existsById(updatedFoodItemDto.getFoodId())){
                FoodItem newFoodItem = new FoodItem(updatedFoodItemDto.getFoodId(), updatedFoodItemDto);
                foodItemRepo.save(newFoodItem);
                return "Food Item updated";
            }else{
                return "Invalid Food Item";
            }
        }else{
            return "Unauthenticated access !";
        }

    }

    public String deleteFoodItem(Long foodItemId, AdminAuthenticationDto adminAuthenticationDto) {
        if(adminAuthenticationTokenService.isAuthenticate(adminAuthenticationDto)){
            if(foodItemRepo.existsById(foodItemId)){
                foodItemRepo.deleteById(foodItemId);
                return "Food Item deleted";
            }else{
                return "Invalid Food Item";
            }
        }else{
            return "Unauthenticated access !";
        }
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepo.findAll();
    }


}
