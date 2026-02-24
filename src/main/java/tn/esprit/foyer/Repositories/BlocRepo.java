package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Bloc;

@Repository
public interface BlocRepo extends JpaRepository<Bloc,Long> {
}
