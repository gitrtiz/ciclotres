package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.Moto;
import com.mintic.ciclotres.entities.MotoCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public class MotoRepository {
    @Autowired
    private MotoCrud motoCrudRepository;
    
    public List<Moto> getAll() {
        return (List<Moto> ) motoCrudRepository.findAll();
    };
    
    public Optional<Moto> getMoto(int id) {
        return motoCrudRepository.findById(id);
    };
    
    public Moto save(Moto moto) {
        return motoCrudRepository.save(moto);
    };
    
    public void delete(Moto moto){
        motoCrudRepository.delete(moto);
    };
    
}
