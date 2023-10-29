package com.geekster.FoodDeliveryProject.model.dto;

import com.geekster.FoodDeliveryProject.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizedUserDto {

    UserAuthenticationDto userAuthenticationDto;
    OrdersDto ordersDto;

}
