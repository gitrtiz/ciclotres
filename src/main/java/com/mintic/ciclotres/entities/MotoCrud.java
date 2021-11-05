package com.mintic.ciclotres.entities;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public interface MotoCrud extends CrudRepository<Moto, Integer> {
    
}
