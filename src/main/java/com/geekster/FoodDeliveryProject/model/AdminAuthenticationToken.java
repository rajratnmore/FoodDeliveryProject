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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = AdminAuthenticationToken.class, property = "adminAuthTokenId")
public class AdminAuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminAuthTokenId;
    private String adminAuthTokenValue;
    private LocalDateTime adminAuthTokenCreationTime;

    @OneToOne
    @JoinColumn(name = "fk_admin_id")
    Admin admin;

    public AdminAuthenticationToken(Admin existedAdmin){
        this.setAdmin(existedAdmin);
        this.setAdminAuthTokenCreationTime(LocalDateTime.now());
        this.setAdminAuthTokenValue(UUID.randomUUID().toString());
    }

}
