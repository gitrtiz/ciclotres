package com.mintic.ciclotres.service;

import com.mintic.ciclotres.dao.ReservationRepository;
import com.mintic.ciclotres.entities.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Edgar
 */
@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    
    public List<Reservation> getAll() {return (List<Reservation>) reservationRepository.getAll();};
    
    public Optional<Reservation> getReservation(int id) {return reservationRepository.getReservation(id);};
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation()==null) {
            reservation.setStatus("created");
            return reservationRepository.save(reservation);
        }
        else {
            Optional<Reservation> co = reservationRepository.getReservation(reservation.getIdReservation());
            if (co.isEmpty()){
                return reservationRepository.save(reservation);
            }
            else {
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation> rsv = reservationRepository.getReservation(reservation.getIdReservation());
            if (!rsv.isEmpty()) {
                if (reservation.getStartDate()!=null) {
                    rsv.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!=null) {
                    rsv.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null) {
                    rsv.get().setStatus(reservation.getStatus());
                }
                if (reservation.getScore()!=null) {
                    rsv.get().setScore(reservation.getScore());
                }
                                
                return reservationRepository.save(rsv.get());
            }
        }
        return reservation;
    }
    
    public boolean delete(int id) {
        Optional<Reservation> rsv = getReservation(id);
        if (!rsv.isEmpty()) {
            reservationRepository.delete(rsv.get());
            return true;
        }
        return false;
    }
}
