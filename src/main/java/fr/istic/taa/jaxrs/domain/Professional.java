package fr.istic.taa.jaxrs.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Professionals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professional extends User {

    @OneToMany(mappedBy = "pro")
    private List<RDV> appointments = new ArrayList<>();
}
