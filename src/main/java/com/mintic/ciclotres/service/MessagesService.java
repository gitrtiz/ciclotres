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
    
    public Messages update(Messages messages){
        if (messages.getIdMessage()!=null){
            Optional<Messages> msg = messagesRepository.getMessages(messages.getIdMessage());
            if (!msg.isEmpty()) {
                if (messages.getMessageText()!=null) {
                    msg.get().setMessageText(messages.getMessageText());
                }
                return messagesRepository.save(msg.get());
            }
        }
        return messages;
    }
    
    public boolean delete(int id) {
        Optional<Messages> msg = getMessages(id);
        if (!msg.isEmpty()) {
            messagesRepository.delete(msg.get());
            return true;
        }
        return false;
    }
}
