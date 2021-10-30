package com.mintic.ciclotres.service;

import com.mintic.ciclotres.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Edgar
 */
@RestController
@RequestMapping("/api/User")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getUsers() {return userService.getAll();};
    
    @GetMapping("/id")
    public Optional<User> getUser(@PathVariable("id") int userId) {
        return userService.getUser(userId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);   
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int userId) {
        return userService.delete(userId);
    }
    
}
