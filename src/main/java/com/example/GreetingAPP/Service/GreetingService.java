package com.example.GreetingAPP.Service;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> UC4
import org.springframework.stereotype.Service;
=======
import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import com.example.GreetingAPP.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
>>>>>>> UC5

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "Hello,World";
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> UC5
    @Autowired
    GreetingMessageRepository greetingMessageRepository;
    // Method to save greeting message
    public Greeting saveGreeting(String message) {
        Greeting greetingMessage = new Greeting(message);
        return greetingMessageRepository.save(greetingMessage);
    }
<<<<<<< HEAD
>>>>>>> UC4
=======

    public MessageDTO findById(Long id){
        Greeting greeting = greetingMessageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No messages found with given id"));

        MessageDTO messageDTO = new MessageDTO(greeting.getMessage());
        messageDTO.setId(greeting.getId());
        return messageDTO;
    }
>>>>>>> UC5
}
