package com.mintic.ciclotres.entities;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Edgar
 */
@Repository
public interface ReservationCrud extends CrudRepository<Reservation, Integer>{
     public List<Reservation> findAllByStatus (String status); 
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT r.client, COUNT(r.client) from Reservation AS r group by r.client order by COUNT(r.client)DESC")
    public List<Object[]> countTotalReservationsByClient();
    
}
