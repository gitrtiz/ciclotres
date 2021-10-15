package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.Messages;
import com.mintic.ciclotres.entities.MessagesCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */

@Repository
public class MessagesRepository {
    @Autowired
    private MessagesCrud messagesCrudRepository;
    
    public List<Messages> getAll() {return (List<Messages>) messagesCrudRepository.findAll();};
    
    public Optional<Messages> getMessages(int id) {return messagesCrudRepository.findById(id);};
    
    public Messages save(Messages messages) {return messagesCrudRepository.save(messages);};
}
