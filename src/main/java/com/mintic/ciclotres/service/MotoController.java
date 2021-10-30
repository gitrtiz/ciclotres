package com.mintic.ciclotres.service;

import com.mintic.ciclotres.entities.Moto;
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
@RequestMapping("/api/Motorbike")
public class MotoController {
    @Autowired
    private MotoService motoService;
    
    @GetMapping("/all")
    public List<Moto> getMotos() {return motoService.getAll();};
    
    @GetMapping("/id")
    public Optional<Moto> getMoto(@PathVariable("id") int motoId) {
        return motoService.getMoto(motoId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Moto save(@RequestBody Moto moto) {
        return motoService.save(moto);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Moto update(@RequestBody Moto moto) {
        return motoService.update(moto);   
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int motoId) {
        return motoService.delete(motoId);
    }
    
}
