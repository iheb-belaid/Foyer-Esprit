package org.example.foyer.Repositories;

import org.example.foyer.Entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository

public interface EtudiantRepo extends JpaRepository<Etudiant, Long> {

    long countByDateNaissanceAfterAndEcole(LocalDate date, String ecole);
    Etudiant findByCin(Long cin);

}
