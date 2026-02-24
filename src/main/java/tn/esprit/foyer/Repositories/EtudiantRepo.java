package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Etudiant;

@Repository
public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
}
