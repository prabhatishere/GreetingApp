package com.example.GreetingAPP.Service;
import com.example.GreetingAPP.Repository.GreetingMessageRepository;
import com.example.GreetingAPP.dto.MessageDTO;
import com.example.GreetingAPP.Entities.Greeting;
import com.example.GreetingAPP.Interface.I_GreetingInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingService implements I_GreetingInterface {

    String message;
    GreetingMessageRepository greetingRepository;

    public GreetingService(GreetingMessageRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
        message = "Hello World!";
    }


    public String getGreetings(){
        return this.message;
    }

    public MessageDTO saveMessage(MessageDTO message){

        Greeting me = new Greeting(message.getMessage());

        greetingRepository.save(me);

        MessageDTO dto = new MessageDTO(me.getMessage());

        dto.setId(me.getId());

        return dto;
    }

    public MessageDTO findById(Long id){

        Greeting m1 = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("No messages found with given id"));

        MessageDTO m2 = new MessageDTO(m1.getMessage());
        m2.setId(m1.getId());

        return m2;

    }

    public List<MessageDTO> listAll(){

        List<MessageDTO> list = greetingRepository.findAll().stream().map(entity -> {
            MessageDTO m = new MessageDTO(entity.getMessage());
            m.setId(entity.getId());
            return m;
        }).collect(Collectors.toList());

        return list;
    }

    public MessageDTO editById(MessageDTO message, Long id){

        Greeting m = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("No Message was found with given id"));

        m.setMessage(message.getMessage());

        greetingRepository.save(m);

        MessageDTO m2 = new MessageDTO(m.getMessage());
        m2.setId(m.getId());

        return m2;
    }

    public String delete(Long id){

        Greeting m = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find message with given id"));

        greetingRepository.delete(m);

        return "Message Deleted";

    }

}