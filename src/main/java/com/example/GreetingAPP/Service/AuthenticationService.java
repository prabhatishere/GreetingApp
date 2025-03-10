package  com.example.GreetingAPP.Service;
import com.example.GreetingAPP.dto.AuthUserDTO;
import com.example.GreetingAPP.dto.LoginDTO;
import com.example.GreetingAPP.dto.PasswordDTO;
import com.example.GreetingAPP.Interface.I_AuthInterface;
import com.example.GreetingAPP.Modal.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.GreetingAPP.Repository.AuthUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;
@Service
public class AuthenticationService implements I_AuthInterface {

    @Autowired
    AuthUserRepository userRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    JwtTokenService jwtTokenService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String register(AuthUserDTO user){

        List<AuthUser> l1 = userRepository.findAll().stream().filter(authuser -> user.getEmail().equals(authuser.getEmail())).collect(Collectors.toList());

        if(l1.size()>0){
            return "User already registered";
        }

        //creating hashed password using bcrypt
        String hashPass = bCryptPasswordEncoder.encode(user.getPassword());

        //creating new user
        AuthUser newUser = new AuthUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), hashPass);

        //setting the new hashed password
        newUser.setHashPass(hashPass);

        //saving the user in the database
        userRepository.save(newUser);

        //sending the confirmation mail to the user
        emailService.sendEmail(user.getEmail(), "Your Account is Ready!", "UserName : "+user.getFirstName()+" "+user.getLastName()+"\nEmail : "+user.getEmail()+"\nYou are registered!\nBest Regards,\nBridgelabz Team");

        return "user registered";
    }


    public String login(LoginDTO user){

        List<AuthUser> l1 = userRepository.findAll().stream().filter(authuser -> authuser.getEmail().equals(user.getEmail())).collect(Collectors.toList());
        if(l1.size() == 0)
            return "User not registered";

        AuthUser foundUser = l1.get(0);

        //matching the stored hashed password with the password provided by user

        if(!bCryptPasswordEncoder.matches(user.getPassword(), foundUser.getHashPass()))
            return "Invalid password";

        //creating Jwt Token
        String token = jwtTokenService.createToken(foundUser.getId());

        //setting token for user login
        foundUser.setToken(token);

        //saving the current status of user in database
        userRepository.save(foundUser);

        return "user logged in"+"\ntoken : "+token;
    }

    public AuthUserDTO forgotPassword(PasswordDTO pass, String email){

        AuthUser foundUser = userRepository.findByEmail(email);

        if(foundUser == null)
            throw new RuntimeException("user not registered!");

        String hashpass = bCryptPasswordEncoder.encode(pass.getPassword());

        foundUser.setPassword(pass.getPassword());
        foundUser.setHashPass(hashpass);

        userRepository.save(foundUser);

        emailService.sendEmail(email, "Password Forgot Status", "Your password has been changed!");

        AuthUserDTO resDto = new AuthUserDTO(foundUser.getFirstName(), foundUser.getLastName(), foundUser.getEmail(), foundUser.getPassword(), foundUser.getId() );

        return resDto;
    }

    public String resetPassword(String email, String currentPass, String newPass){

        AuthUser foundUser = userRepository.findByEmail(email);

        if(foundUser == null)
            return "user not registered!";

        if(!bCryptPasswordEncoder.matches(currentPass, foundUser.getHashPass()))
            return "incorrect password!";

        foundUser.setHashPass(bCryptPasswordEncoder.encode(newPass));
        foundUser.setPassword(newPass);

        userRepository.save(foundUser);

        emailService.sendEmail(email, "Password reset status", "Your password is reset successfully");

        return "Password reset successfull!";
    }
}