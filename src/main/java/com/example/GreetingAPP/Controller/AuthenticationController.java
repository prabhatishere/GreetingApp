package com.example.GreetingAPP.Controller;
import com.example.GreetingAPP.dto.*;
import com.example.GreetingAPP.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.GreetingAPP.Interface.I_AuthInterface;

@RestController
public class AuthenticationController {
    EmailService emailService;
    @Autowired
            I_AuthInterface iAuthInterface;

//============================UC9(Register and Login for a User)==============================================//
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user){
        return iAuthInterface.register(user);
    }

    @PostMapping(path ="/login")
    public String login(@RequestBody LoginDTO user){

        return iAuthInterface.login(user);
    }
//===========================UC10(Send Mail)===========================================//
    @PostMapping(path="/sendMail")
    public String sendMail(@RequestBody MailDTO user){ emailService.sendEmail(user.getTo(), user.getSubject(), user.getBody());
    return "Mail Sent";
    }


    //=======================UC11(forgot Passwrod implementation)====================================================================//
    @PutMapping("forgotPassword/{email}")
    public AuthUserDTO forgotPassword(@RequestBody PasswordDTO pass, @PathVariable String email){
        return iAuthInterface.forgotPassword(pass, email);
    }

//=======================================UC12(Reset Password)=========================================================================//
    @PutMapping("/resetPassword/{email}")
    public String resetPassword(@PathVariable String email ,@RequestParam String currentPass, @RequestParam String newPass){
        return iAuthInterface.resetPassword(email, currentPass, newPass);
    }


}