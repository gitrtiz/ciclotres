package com.mintic.ciclotres.service;

import com.mintic.ciclotres.dao.MessagesRepository;
import com.mintic.ciclotres.entities.Messages;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class MessagesService {
    @Autowired
    MessagesRepository messagesRepository;
    
    public List<Messages> getAll() {return (List<Messages>) messagesRepository.getAll();};
    
    public Optional<Messages> getMessages(int id) {return messagesRepository.getMessages(id);};
    
    public Messages save(Messages messages) {
        if (messages.getIdMessage()==null) {
            return messagesRepository.save(messages);
        }
        else {
            Optional<Messages> co = messagesRepository.getMessages(messages.getIdMessage());
            if (co.isEmpty()){
                return messagesRepository.save(messages);
            }
            else {
                return messages;
            }
        }
    }
}
