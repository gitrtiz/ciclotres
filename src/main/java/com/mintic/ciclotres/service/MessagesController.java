package com.mintic.ciclotres.service;

import com.mintic.ciclotres.entities.Messages;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edgar
 */
@RestController
@RequestMapping("/api/Message")
public class MessagesController {
    @Autowired
    private MessagesService messagesService;
    
    @GetMapping("/all")
    public List<Messages> getMessagess() {return messagesService.getAll();};
    
    @GetMapping("/id")
    public Optional<Messages> getMessages(@PathVariable("id") int messagesId) {
        return messagesService.getMessages(messagesId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages save(@RequestBody Messages messages) {return messagesService.save(messages);}
}
