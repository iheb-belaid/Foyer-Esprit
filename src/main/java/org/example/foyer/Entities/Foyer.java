package org.example.foyer.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer ;
    String nomFoyer ;
    long capaciteFoyer ;
    @OneToOne(mappedBy = "foyer")
    @JsonIgnore
    Universite universite;
    @OneToMany(mappedBy = "foyer")
    Set<Bloc> blocs ;
}
