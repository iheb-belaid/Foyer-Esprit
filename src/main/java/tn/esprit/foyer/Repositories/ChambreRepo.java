package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Bloc;
import tn.esprit.foyer.Entities.Chambre;

@Repository
public interface ChambreRepo extends JpaRepository<Chambre,Long> {
}
