package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Universite;

@Repository
public interface UniversiteRepo extends JpaRepository<Universite,Long> {
}
