package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.Client;
import com.mintic.ciclotres.entities.Reservation;
import com.mintic.ciclotres.entities.ReservationCrud;
import com.mintic.ciclotres.report.ClientCont;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrud reservationCrudRepository;
    
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    };
    
    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    };
    
    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    };
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    };
    
    public List<Reservation> ReservationStatusRepositorio (String status){
         return reservationCrudRepository.findAllByStatus(status);
     }
     
     public List<Reservation> ReservationTiempoRepositorio (Date a, Date b){
         return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
     
     public List<ClientCont> getClientesRepositorio(){
         List<ClientCont> res = new ArrayList<>();
         List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
         for(int i=0; i<report.size(); i++){
             res.add(new ClientCont((Long)report.get(i)[1],(Client) report.get(i)[0]));
         }
         return res;
     }
}
