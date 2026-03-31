package org.example.foyer.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;
    String nomEt;
    String prenomEt;
    Long cin ;
    String ecole ;
    LocalDate dateNaissance;
    @ManyToMany(mappedBy = "etudiants")
    @JsonIgnore
    Set<Reservation> reservations ;
}
