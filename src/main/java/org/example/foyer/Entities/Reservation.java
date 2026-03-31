package org.example.foyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.foyer.Entities.Etudiant;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    private Long idReservation;

    private String numReservation;

    private LocalDate anneeUniversitaire;

    private boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("reservations")
    private Set<Etudiant> etudiants = new java.util.HashSet<>();
}
