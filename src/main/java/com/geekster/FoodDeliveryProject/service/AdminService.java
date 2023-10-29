package com.geekster.FoodDeliveryProject.service;

import com.geekster.FoodDeliveryProject.model.Admin;
import com.geekster.FoodDeliveryProject.model.AdminAuthenticationToken;
import com.geekster.FoodDeliveryProject.model.dto.SignInDto;
import com.geekster.FoodDeliveryProject.model.dto.AdminAuthenticationDto;
import com.geekster.FoodDeliveryProject.repo.IAdminRepo;
import com.geekster.FoodDeliveryProject.service.hashingUtility.PasswordEncryptor;
import com.geekster.FoodDeliveryProject.service.mailUtility.EmailHandler;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    AdminAuthenticationTokenService adminAuthenticationTokenService;

    public String adminSingUp(@NotNull Admin newAdmin) {
        Admin existedAdmin = adminRepo.findByAdminEmail(newAdmin.getAdminEmail());
        if(existedAdmin != null){
            return "admin already existed";
        }

        try {
            String encryptedPassword = PasswordEncryptor.getEncryptedPassword(newAdmin.getAdminPassword());
            newAdmin.setAdminPassword(encryptedPassword);
            adminRepo.save(newAdmin);
            return "account created successfully";
        }catch (Exception ex){
            return "Something went wrong while password encryption";
        }

    }

    public String adminSingIn(@NotNull SignInDto signInDto) {
        Admin existedAdmin = adminRepo.findByAdminEmail(signInDto.getEmail());
        if(existedAdmin == null){
            return "Invalid credential";
        }

        try {
            String encryptedPassword = PasswordEncryptor.getEncryptedPassword(signInDto.getPassword());
            if(existedAdmin.getAdminPassword().equals(encryptedPassword)){
                AdminAuthenticationToken adminAuthenticationToken = new AdminAuthenticationToken(existedAdmin);
                if(EmailHandler.sendMail(signInDto.getEmail(), "Token Value after Sign In", adminAuthenticationToken.getAdminAuthTokenValue())){
                    adminAuthenticationTokenService.tokenCreate(adminAuthenticationToken);
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


    public String adminSignOut(AdminAuthenticationDto adminAuthenticationDto) {
        if(adminAuthenticationTokenService.isAuthenticate(adminAuthenticationDto)){
            adminAuthenticationTokenService.deleteToken(adminAuthenticationDto.getTokenValue());
            return "Signed out successfully";
        }else{
            return "Unauthenticated access !";
        }
    }

}
