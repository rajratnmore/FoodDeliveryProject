package com.geekster.FoodDeliveryProject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.FoodDeliveryProject.model.dto.FoodItemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = FoodItem.class, property = "foodId")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    private String foodTitle;
    private String foodDescription;
    private double foodPrice;
    private LocalDateTime foodAddedDateTime;

    public FoodItem(FoodItemDto foodItemDto){
        this.setFoodTitle(foodItemDto.getFoodTitle());
        this.setFoodDescription(foodItemDto.getFoodDescription());
        this.setFoodPrice(foodItemDto.getFoodPrice());
        this.setFoodAddedDateTime(LocalDateTime.now());
    }

    public FoodItem(Long foodId, FoodItemDto foodItemDto){
        this.setFoodId(foodId);
        this.setFoodTitle(foodItemDto.getFoodTitle());
        this.setFoodDescription(foodItemDto.getFoodDescription());
        this.setFoodPrice(foodItemDto.getFoodPrice());
        this.setFoodAddedDateTime(LocalDateTime.now());
    }

}
