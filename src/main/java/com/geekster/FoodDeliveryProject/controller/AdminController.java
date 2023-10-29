package com.geekster.FoodDeliveryProject.controller;

import com.geekster.FoodDeliveryProject.model.Admin;
import com.geekster.FoodDeliveryProject.model.FoodItem;
import com.geekster.FoodDeliveryProject.model.Orders;
import com.geekster.FoodDeliveryProject.model.dto.AuthorizedAdminDto;
import com.geekster.FoodDeliveryProject.model.dto.SignInDto;
import com.geekster.FoodDeliveryProject.model.dto.AdminAuthenticationDto;
import com.geekster.FoodDeliveryProject.service.AdminService;
import com.geekster.FoodDeliveryProject.service.FoodItemService;
import com.geekster.FoodDeliveryProject.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    OrdersService ordersService;

    @PostMapping("adminSignUp")
    public String adminSingUp(@RequestBody Admin newAdmin){
        return adminService.adminSingUp(newAdmin);
    }

    @PostMapping("adminSignIn")
    public String adminSingIn(@RequestBody SignInDto signInDto){
        return adminService.adminSingIn(signInDto);
    }

    @PostMapping("adminSignOut")
    public String adminSignOut(@RequestBody AdminAuthenticationDto adminAuthenticationDto){
        return adminService.adminSignOut(adminAuthenticationDto);
    }

    @PostMapping("addFoodItem")
    public String addFoodItem(@RequestBody AuthorizedAdminDto authorizedAdminDto){
        return foodItemService.addFoodItem(authorizedAdminDto);
    }

    @PutMapping("updateFoodItem")
    public String updateFoodItem(@RequestBody AuthorizedAdminDto authorizedAdminDto){
        return foodItemService.updateFoodItem(authorizedAdminDto);
    }

    @DeleteMapping("deleteFoodItem/{foodItemId}")
    public String deleteFoodItem(@PathVariable Long foodItemId, @RequestBody AdminAuthenticationDto adminAuthenticationDto){
        return foodItemService.deleteFoodItem(foodItemId,adminAuthenticationDto);
    }

    @GetMapping("foodItems")
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("orders")
    public List<Orders> getAllOrders(){
        return ordersService.getAllOrders();
    }


}
