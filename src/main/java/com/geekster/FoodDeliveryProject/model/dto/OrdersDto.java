package com.geekster.FoodDeliveryProject.model.dto;

import com.geekster.FoodDeliveryProject.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {

    private Long orderId;
    @Enumerated(value = EnumType.STRING)
    private Status orderStatus;
    private Long orderQuantity;
    private Long foodItemId;

}
