package com.geekster.FoodDeliveryProject.model.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthenticationDto {

    @Email
    private String email;
    private String tokenValue;

}
