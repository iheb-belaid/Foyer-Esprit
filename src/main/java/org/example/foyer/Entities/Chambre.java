package org.example.foyer.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "chambre")
@NoArgsConstructor
@AllArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre ;
    Long numeroChambre ;
    @Enumerated(EnumType.STRING)
    TypeChambre typec;
    @ManyToOne
    @JsonIgnoreProperties({"chambres", "foyer"})
    Bloc bloc;
    @OneToMany
    Set<Reservation>  reservations ;
}


