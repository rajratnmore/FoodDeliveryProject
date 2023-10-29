package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.User;
import com.geekster.FoodDeliveryProject.model.UserAuthenticationToken;
import com.geekster.FoodDeliveryProject.model.dto.UserAuthenticationDto;
import com.geekster.FoodDeliveryProject.repo.IUserAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationTokenService {

    @Autowired
    IUserAuthenticationTokenRepo userAuthenticationTokenRepo;

    public String tokenCreate(UserAuthenticationToken userAuthenticationToken) {
        userAuthenticationTokenRepo.save(userAuthenticationToken);
        return userAuthenticationToken.getUserAuthTokenValue();
    }

    public boolean isAuthenticate(UserAuthenticationDto userAuthenticationDto) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationTokenRepo.findByUserAuthTokenValue(userAuthenticationDto.getTokenValue());
        if(userAuthenticationToken == null){
            return false;
        }else{
            User existedUser = userAuthenticationToken.getUser();
            return existedUser.getUserEmail().equals(userAuthenticationDto.getEmail());
        }
    }

    public void deleteToken(String tokenValue) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationTokenRepo.findByUserAuthTokenValue(tokenValue);
        userAuthenticationTokenRepo.delete(userAuthenticationToken);
    }

}
