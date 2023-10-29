package com.geekster.FoodDeliveryProject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = UserAuthenticationToken.class, property = "userAuthTokenId")
public class UserAuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAuthTokenId;
    private String userAuthTokenValue;
    private LocalDateTime userAuthTokenCreationTime;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    User user;

    public UserAuthenticationToken(User existedUser){
        this.setUser(existedUser);
        this.setUserAuthTokenCreationTime(LocalDateTime.now());
        this.setUserAuthTokenValue(UUID.randomUUID().toString());
    }

}
