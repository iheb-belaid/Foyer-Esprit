package org.example.foyer.Repositories;

import org.example.foyer.Entities.Bloc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocRepo extends JpaRepository<Bloc, Long> {
}
