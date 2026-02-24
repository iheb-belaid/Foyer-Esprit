package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Foyer;

@Repository
public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
