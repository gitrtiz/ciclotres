package com.mintic.ciclotres.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public interface ClientCrud extends CrudRepository<Client, Integer>{
    
}
