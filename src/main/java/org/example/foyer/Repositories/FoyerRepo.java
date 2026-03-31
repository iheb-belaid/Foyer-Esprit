package org.example.foyer.Repositories;

import org.example.foyer.Entities.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FoyerRepo extends JpaRepository<Foyer, Long> {
    Foyer findByNomFoyer(String nomFoyer);
    List<Foyer> findByNomFoyerAndCapaciteFoyerLessThan(String nomFoyer, long capaciteFoyer);
}
