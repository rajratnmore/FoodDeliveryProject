package com.geekster.FoodDeliveryProject.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizedAdminDto {

    AdminAuthenticationDto adminAuthenticationDto;
    FoodItemDto foodItemDto;

}
