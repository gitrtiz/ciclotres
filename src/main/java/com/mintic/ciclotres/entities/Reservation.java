package com.mintic.ciclotres.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Edgar
 */
@Entity
@Table (name="Reservation")
public class Reservation implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idReservation;
    @Column(name = "startDate", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Calendar startDate;
    @Column(name = "devolutionDate", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    //@Temporal(javax.persistence.TemporalType.DATE)
    private Calendar devolutionDate;
    //@Column(name="status", nullable = false, length = 8 )
    //@Enumerated(value = EnumType.STRING)
    private String status;
    
    @ManyToOne
    @JoinColumn(name="moto_id")
    @JsonIgnoreProperties("reservations") //lista definida en la entidad Moto.java
    private Moto motorbike;
    
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages","reservations"}) //lista definida en la entidad Reservation.java
    private Client client;
    
    private String score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Calendar devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Moto getMotorbike() {
        return motorbike;
    }

    public void setMotorbike(Moto motorbike) {
        this.motorbike = motorbike;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

     
}
