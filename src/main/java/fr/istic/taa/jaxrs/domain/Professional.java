package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Professionals")
public class Professional extends User {

    private List<RDV> appointments = new ArrayList<>();

    public Professional(String email, String password, String name) {
        super(email, password, name);
    }

    public Professional() {}

    @OneToMany(mappedBy = "professional")
    public List<RDV> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<RDV> appointments) {
        this.appointments = appointments;
    }
}
