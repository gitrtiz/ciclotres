package com.mintic.ciclotres.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Edgar
 */
@Entity
@Table (name="Moto")
public class Moto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    @JsonIgnoreProperties("motorbikes") //lista definida en la entidad Moto.java
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="motorbike")
    @JsonIgnoreProperties({"motorbike","client"})  //lista definida en la entidad Messages.java
    private List<Messages> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy="motorbike")
    @JsonIgnoreProperties("motorbike")  //lista definida en la entidad Reservation.java
    private List<Messages> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Messages> getReservations() {
        return reservations;
    }

    public void setReservations(List<Messages> reservations) {
        this.reservations = reservations;
    }

    
}
