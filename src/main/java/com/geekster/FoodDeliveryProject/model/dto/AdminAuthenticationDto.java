package com.geekster.FoodDeliveryProject.model.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAuthenticationDto {

    @Email
    private String email;
    private String tokenValue;

}
