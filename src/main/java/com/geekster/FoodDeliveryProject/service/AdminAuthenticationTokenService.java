package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.Admin;
import com.geekster.FoodDeliveryProject.model.AdminAuthenticationToken;
import com.geekster.FoodDeliveryProject.model.dto.AdminAuthenticationDto;
import com.geekster.FoodDeliveryProject.repo.IAdminAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationTokenService {

    @Autowired
    IAdminAuthenticationTokenRepo adminAuthenticationRepo;

    public String  tokenCreate(AdminAuthenticationToken adminAuthenticationToken) {
        adminAuthenticationRepo.save(adminAuthenticationToken);
        return adminAuthenticationToken.getAdminAuthTokenValue();
    }

    public boolean isAuthenticate(AdminAuthenticationDto adminAuthenticationDto) {
        AdminAuthenticationToken adminAuthenticationToken = adminAuthenticationRepo.findByAdminAuthTokenValue(adminAuthenticationDto.getTokenValue());
        if(adminAuthenticationToken == null){
            return false;
        }else{
            Admin existedAdmin = adminAuthenticationToken.getAdmin();
            return existedAdmin.getAdminEmail().equals(adminAuthenticationDto.getEmail());
        }
    }

    public void deleteToken(String tokenValue) {
        AdminAuthenticationToken adminAuthenticationToken = adminAuthenticationRepo.findByAdminAuthTokenValue(tokenValue);
        adminAuthenticationRepo.delete(adminAuthenticationToken);
    }
}
