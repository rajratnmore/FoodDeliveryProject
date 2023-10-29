package com.geekster.FoodDeliveryProject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.FoodDeliveryProject.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = User.class, property = "userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Pattern(regexp = "^[A-Za-z]+$")
    private String userFirstName;
    @Pattern(regexp = "^[A-Za-z]+$")
    private String userLastName;
    @Email
    @Column(unique = true)
    private String userEmail;
    @NotBlank
    private String userPassword;
    private LocalDate userDOB;
    @Enumerated(value = EnumType.STRING)
    private Gender userGender;
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d+")
    private String userPhoneNumber;

}
