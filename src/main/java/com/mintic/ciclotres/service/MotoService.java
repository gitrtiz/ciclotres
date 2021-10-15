package com.mintic.ciclotres.service;

import com.mintic.ciclotres.dao.MotoRepository;
import com.mintic.ciclotres.entities.Moto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class MotoService {
    @Autowired
    MotoRepository motoRepository;
    
    public List<Moto> getAll() {return (List<Moto> ) motoRepository.getAll();};
    
    public Optional<Moto> getMoto(int id) {return motoRepository.getMoto(id);};
    
    public Moto save(Moto moto) {
        if (moto.getId()==null) {
            return motoRepository.save(moto);
        }
        else {
            Optional<Moto> co = motoRepository.getMoto(moto.getId());
            if (co.isEmpty()){
                return motoRepository.save(moto);
            }
            else {
                return moto;
            }
        }
    }
}
