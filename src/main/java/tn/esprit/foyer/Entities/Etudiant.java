package tn.esprit.foyer.Entities;

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
    private Long idEtudiant;

    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    private LocalDate dateNaissance;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;


}
