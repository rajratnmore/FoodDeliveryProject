package com.geekster.FoodDeliveryProject.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.geekster.FoodDeliveryProject.model.enums.Gender;
import jakarta.persistence.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Admin.class, property = "adminId")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    @Pattern(regexp = "^[A-Za-z]+$")
    private String adminFirstName;
    @Pattern(regexp = "^[A-Za-z]+$")
    private String adminLastName;
    @Pattern(regexp = ".*@admin\\.restaurant\\.com$")
    @Column(unique = true)
    private String adminEmail;
    @NotBlank
    private String adminPassword;
    private LocalDate adminDOB;
    @Enumerated(value = EnumType.STRING)
    private Gender adminGender;
    @Size(min = 10, max = 10)
    @Pattern(regexp = "\\d+")
    private String adminPhoneNumber;


}
