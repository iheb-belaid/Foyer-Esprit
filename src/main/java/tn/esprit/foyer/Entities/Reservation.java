package tn.esprit.foyer.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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


    private LocalDate anneeUniversitaire;

    private boolean estValide;

    @ManyToMany
    private Set<Etudiant> etudiants;
}
