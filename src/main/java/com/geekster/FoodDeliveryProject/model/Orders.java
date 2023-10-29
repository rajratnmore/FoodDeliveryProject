package com.geekster.FoodDeliveryProject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.FoodDeliveryProject.model.dto.OrdersDto;
import com.geekster.FoodDeliveryProject.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Orders.class, property = "orderId")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Enumerated(value = EnumType.STRING)
    private Status orderStatus;
    private Long orderQuantity;
    private LocalDateTime orderCreationTime;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "fk_foodItem_id")
    FoodItem foodItem;

    public Orders(User existedUser, FoodItem existedFoodItem, OrdersDto ordersDto) {
        this.setUser(existedUser);
        this.setFoodItem(existedFoodItem);
        this.setOrderStatus(ordersDto.getOrderStatus());
        this.setOrderQuantity(ordersDto.getOrderQuantity());
        this.setOrderCreationTime(LocalDateTime.now());
    }
}
