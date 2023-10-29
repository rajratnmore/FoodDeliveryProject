package com.geekster.FoodDeliveryProject.controller;

import com.geekster.FoodDeliveryProject.model.Orders;
import com.geekster.FoodDeliveryProject.model.User;
import com.geekster.FoodDeliveryProject.model.dto.AuthorizedUserDto;
import com.geekster.FoodDeliveryProject.model.dto.UserAuthenticationDto;
import com.geekster.FoodDeliveryProject.model.dto.SignInDto;
import com.geekster.FoodDeliveryProject.service.OrdersService;
import com.geekster.FoodDeliveryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrdersService ordersService;

    @PostMapping("userSignUp")
    public String userSingUp(@RequestBody User newuser){
        return userService.userSingUp(newuser);
    }

    @PostMapping("userSignIn")
    public String userSingIn(@RequestBody SignInDto signInDto){
        return userService.userSingIn(signInDto);
    }

    @PostMapping("userSignOut")
    public String userSignOut(@RequestBody UserAuthenticationDto userAuthenticationDto){
        return userService.userSignOut(userAuthenticationDto);
    }

    @PostMapping("orderFoodItem")
    public String orderFoodItem(@RequestBody AuthorizedUserDto authorizedUserDto){
        return ordersService.orderFoodItem(authorizedUserDto);
    }

    @GetMapping("orders/{tokenValue}")
    public List<Orders> getAllOrdersByUser(@PathVariable String tokenValue){
        return userService.getAllOrdersByUser(tokenValue);
    }

}
