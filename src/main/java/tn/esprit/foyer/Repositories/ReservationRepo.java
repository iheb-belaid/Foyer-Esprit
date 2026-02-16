package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {
}
