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
    
    public Moto update(Moto moto){
        if (moto.getId()!=null){
            Optional<Moto> mt = motoRepository.getMoto(moto.getId());
            if (!mt.isEmpty()) {
                if (moto.getName()!=null) {
                    mt.get().setName(moto.getName());
                }
                if (moto.getBrand()!=null) {
                    mt.get().setBrand(moto.getBrand());
                }
                if (moto.getYear()!=null) {
                    mt.get().setYear(moto.getYear());
                }
                if (moto.getDescription()!=null) {
                    mt.get().setDescription(moto.getDescription());
                }
                                
                return motoRepository.save(mt.get());
            }
        }
        return moto;
    }
    
    public boolean delete(int id) {
        Optional<Moto> mt = getMoto(id);
        if (!mt.isEmpty()) {
            motoRepository.delete(mt.get());
            return true;
        }
        return false;
    }
}
