package com.mintic.ciclotres.service;

import com.mintic.ciclotres.dao.UserRepository;
import com.mintic.ciclotres.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public List<User> getAll() {
        return (List<User>) userRepository.getAll();
    };
    
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    };
    
    public User save(User user) {
        if (user.getId()==null) {
            return userRepository.save(user);
        }
        else {
            Optional<User> co = userRepository.getUser(user.getId());
            if (co.isEmpty()){
                return userRepository.save(user);
            }
            else {
                return user;
            }
        }
    }
    
    public User update(User user){
        if (user.getId()!=null){
            Optional<User> g = userRepository.getUser(user.getId());
            if (!g.isEmpty()) {
                if (user.getMail()!=null) {
                    g.get().setMail(user.getMail());
                }
                if (user.getName()!=null) {
                    g.get().setName(user.getName());
                }
                if (user.getPassword()!=null) {
                    g.get().setPassword(user.getPassword());
                }
                return userRepository.save(g.get());
            }
        }
        return user;
    }
    
    public boolean delete(int id) {
        Optional<User> c = getUser(id);
        if (!c.isEmpty()) {
            userRepository.delete(c.get());
            return true;
        }
        return false;
    }
}
