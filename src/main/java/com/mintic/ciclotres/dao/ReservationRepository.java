package com.mintic.ciclotres.dao;

import com.mintic.ciclotres.entities.Reservation;
import com.mintic.ciclotres.entities.ReservationCrud;
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
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationCrudRepository.findAll();};
    
    public Optional<Reservation> getReservation(int id) {return reservationCrudRepository.findById(id);};
    
    public Reservation save(Reservation reservation) {return reservationCrudRepository.save(reservation);};
}
