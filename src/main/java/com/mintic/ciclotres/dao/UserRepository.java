package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.User;
import com.mintic.ciclotres.entities.UserCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrud userCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    };
    
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    };
    
    public User save(User user) {
        return userCrudRepository.save(user);
    };
    
    public void delete(User user){
        userCrudRepository.delete(user);
    };
}
