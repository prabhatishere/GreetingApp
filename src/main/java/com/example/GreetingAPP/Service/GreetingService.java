package com.example.GreetingAPP.Service;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> UC4
import org.springframework.stereotype.Service;
=======
=======
>>>>>>> UC6
import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import com.example.GreetingAPP.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
<<<<<<< HEAD
>>>>>>> UC5
=======

import java.util.List;
import java.util.stream.Collectors;
>>>>>>> UC6

@Service
public class GreetingService {
    public String getGreetingMessage(){
        return "Hello,World";
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> UC5
=======
>>>>>>> UC6
    @Autowired
    GreetingMessageRepository greetingMessageRepository;
    // Method to save greeting message
    public Greeting saveGreeting(String message) {
        Greeting greetingMessage = new Greeting(message);
        return greetingMessageRepository.save(greetingMessage);
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> UC4
=======
=======
>>>>>>> UC6

    public MessageDTO findById(Long id){
        Greeting greeting = greetingMessageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No messages found with given id"));

        MessageDTO messageDTO = new MessageDTO(greeting.getMessage());
        messageDTO.setId(greeting.getId());
        return messageDTO;
    }
<<<<<<< HEAD
>>>>>>> UC5
=======
    public List<MessageDTO> listAll(){

        List<MessageDTO> list = greetingMessageRepository.findAll().stream().map(entity -> {
            MessageDTO m = new MessageDTO(entity.getMessage());
            m.setId(entity.getId());
            return m;
        }).collect(Collectors.toList());

        return list;
    }

    public MessageDTO editById(MessageDTO message, Long id){

        Greeting m = greetingMessageRepository.findById(id).orElseThrow(() -> new RuntimeException("No Message was found with given id"));

        m.setMessage(message.getMessage());

        greetingMessageRepository.save(m);

        MessageDTO m2 = new MessageDTO(m.getMessage());
        m2.setId(m.getId());

        return m2;
    }

>>>>>>> UC6
}
