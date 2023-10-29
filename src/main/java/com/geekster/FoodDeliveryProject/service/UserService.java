package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.*;
import com.geekster.FoodDeliveryProject.model.dto.SignInDto;
import com.geekster.FoodDeliveryProject.model.dto.UserAuthenticationDto;
import com.geekster.FoodDeliveryProject.repo.IOrdersRepo;
import com.geekster.FoodDeliveryProject.repo.IUserAuthenticationTokenRepo;
import com.geekster.FoodDeliveryProject.repo.IUserRepo;
import com.geekster.FoodDeliveryProject.service.hashingUtility.PasswordEncryptor;
import com.geekster.FoodDeliveryProject.service.mailUtility.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    UserAuthenticationTokenService userAuthenticationTokenService;

    @Autowired
    IUserAuthenticationTokenRepo userAuthenticationTokenRepo;

    @Autowired
    IOrdersRepo ordersRepo;

    public String userSingUp(User newUser) {
        User existedUser = userRepo.findByUserEmail(newUser.getUserEmail());
        if(existedUser != null){
            return "User already existed";
        }

        try {
            String encryptedPassword = PasswordEncryptor.getEncryptedPassword(newUser.getUserPassword());
            newUser.setUserPassword(encryptedPassword);
            userRepo.save(newUser);
            System.out.println("pass 1"+encryptedPassword);
            return "account created successfully";
        }catch (Exception ex){
            return "Something went wrong while password encryption";
        }
    }

    public String userSingIn(SignInDto signInDto) {
        User existedUser = userRepo.findByUserEmail(signInDto.getEmail());
        if(existedUser == null){
            return "Invalid credential";
        }

        try {
            String encryptedPassword = PasswordEncryptor.getEncryptedPassword(signInDto.getPassword());
            if(existedUser.getUserPassword().equals(encryptedPassword)){
                UserAuthenticationToken userAuthenticationToken = new UserAuthenticationToken(existedUser);
                if(EmailHandler.sendMail(signInDto.getEmail(), "Token Value after Sign In", userAuthenticationToken.getUserAuthTokenValue())){
                    userAuthenticationTokenService.tokenCreate(userAuthenticationToken);
                    return "Token sent successfully on "+signInDto.getEmail();
                }else{
                    return "Something went wrong while mailing encrypted password";
                }
            }else{
                return "Invalid credential";
            }
        }catch (Exception ex){
            return "Something went wrong while password encryption";
        }
    }

    public String userSignOut(UserAuthenticationDto userAuthenticationDto) {
        if(userAuthenticationTokenService.isAuthenticate(userAuthenticationDto)){
            userAuthenticationTokenService.deleteToken(userAuthenticationDto.getTokenValue());
            return "Signed out successfully";
        }else{
            return "Unauthenticated access !";
        }

    }

    public List<Orders> getAllOrdersByUser(String tokenValue) {
        UserAuthenticationToken userAuthenticationToken = userAuthenticationTokenRepo.findByUserAuthTokenValue(tokenValue);
        if(userAuthenticationToken == null){
            return null;
        }
        User existedUser = userAuthenticationToken.getUser();
        return ordersRepo.findByUserUserId(existedUser.getUserId());
    }

}
