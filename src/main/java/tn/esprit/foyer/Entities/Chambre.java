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
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ToString.Exclude
    @ManyToOne
    private Bloc bloc;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> reservations;
}
