package org.example.foyer.Repositories;

import org.example.foyer.Entities.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite, Long> {

    Universite findByNomUniversite(String nomUniversite);
}
