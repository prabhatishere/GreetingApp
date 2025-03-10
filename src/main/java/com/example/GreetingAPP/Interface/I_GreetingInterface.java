package com.example.GreetingAPP.Interface;


import com.example.GreetingAPP.dto.MessageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface I_GreetingInterface {

    public String getGreetings();

    public MessageDTO saveMessage(MessageDTO message);

    public MessageDTO findById(Long id);

    public List<MessageDTO> listAll();

    public MessageDTO editById(MessageDTO message, Long id);

    public String delete(Long id);

}
