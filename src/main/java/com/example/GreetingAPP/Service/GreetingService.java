package com.example.GreetingAPP.Service;

import com.example.GreetingAPP.Modal.Greeting;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import com.example.GreetingAPP.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    public MessageDTO findById(Long id){
        Greeting greeting = greetingMessageRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No messages found with given id"));

        MessageDTO messageDTO = new MessageDTO(greeting.getMessage());
        messageDTO.setId(greeting.getId());
        return messageDTO;
    }
    public List<MessageDTO> listAll(){

        List<MessageDTO> list = greetingMessageRepository.findAll().stream().map(entity -> {
            MessageDTO m = new MessageDTO(entity.getMessage());
            m.setId(entity.getId());
            return m;
        }).collect(Collectors.toList());

        return list;
    }



}
