package com.example.GreetingAPP.Service;

import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "Hello,World";
    }
    @Autowired
    GreetingMessageRepository greetingMessageRepository;
    // Method to save greeting message
    public Greeting saveGreeting(String message) {
        Greeting greetingMessage = new Greeting(message);
        return greetingMessageRepository.save(greetingMessage);
    }
}
