package fr.istic.taa.jaxrs.domain;

import fr.istic.taa.jaxrs.domain.Client;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "RDV")
public class RDV implements Serializable {
    private Long id;

    private String date;

    private int duration;

    private String name;

    private Client client;

    private Professional pro;

    private boolean isReserved;

    public RDV(Long id, String date, int duration, String name, Client client, boolean isReserved) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.name = name;
        this.client = client;
        this.isReserved = isReserved;
    }

    public RDV(){};


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    public Professional getPro() {
        return pro;
    }

    public void setPro(Professional pro) {
        this.pro = pro;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }
}
