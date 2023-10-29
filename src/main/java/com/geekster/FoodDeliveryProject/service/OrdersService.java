package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.FoodItem;
import com.geekster.FoodDeliveryProject.model.Orders;
import com.geekster.FoodDeliveryProject.model.User;
import com.geekster.FoodDeliveryProject.model.dto.AuthorizedUserDto;
import com.geekster.FoodDeliveryProject.model.dto.OrdersDto;
import com.geekster.FoodDeliveryProject.model.dto.UserAuthenticationDto;
import com.geekster.FoodDeliveryProject.repo.IFoodItemRepo;
import com.geekster.FoodDeliveryProject.repo.IOrdersRepo;
import com.geekster.FoodDeliveryProject.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    IOrdersRepo ordersRepo;

    @Autowired
    UserAuthenticationTokenService userAuthenticationTokenService;

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    IUserRepo userRepo;

    public String orderFoodItem(AuthorizedUserDto authorizedUserDto) {
        UserAuthenticationDto userAuthenticationDto = authorizedUserDto.getUserAuthenticationDto();
        if(userAuthenticationTokenService.isAuthenticate(userAuthenticationDto)){
            OrdersDto ordersDto = authorizedUserDto.getOrdersDto();
            FoodItem existedFoodItem = foodItemRepo.findById(ordersDto.getFoodItemId()).orElse(null);
            User existedUser = userRepo.findByUserEmail(userAuthenticationDto.getEmail());
            if(existedFoodItem == null){
                return "Invalid Food Item";
            }
            Orders orders = new Orders(existedUser,existedFoodItem,ordersDto);
            ordersRepo.save(orders);
            return "Your order placed";
        }else{
            return "Un authorized access";
        }
    }

    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }
}
