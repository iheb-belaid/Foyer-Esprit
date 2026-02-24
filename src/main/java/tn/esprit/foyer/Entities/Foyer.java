package tn.esprit.foyer.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;

    @ToString.Exclude
    @OneToOne(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Universite universite;

    @ToString.Exclude
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bloc> blocs;


}
