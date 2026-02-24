package tn.esprit.foyer.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    private String nomBloc;
    private Long capaciteBloc;

    @ToString.Exclude
    @ManyToOne
    private Foyer foyer;

    @ToString.Exclude
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chambre> chambres;


}
