package com.example.GreetingAPP.Interface;
import com.example.GreetingAPP.dto.LoginDTO;
import com.example.GreetingAPP.dto.AuthUserDTO;

import com.example.GreetingAPP.dto.PasswordDTO;

import org.springframework.stereotype.Service;

@Service
public interface I_AuthInterface {

    public String register(AuthUserDTO user);


    public String login(LoginDTO user);

    public AuthUserDTO forgotPassword(PasswordDTO password, String email);

    public String resetPassword(String email,String curretPass,String newPass);

}