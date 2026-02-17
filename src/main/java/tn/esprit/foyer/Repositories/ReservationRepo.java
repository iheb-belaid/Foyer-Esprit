package tn.esprit.foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.Entities.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation,Long> {

    @Query("select coalesce(max(r.idReservation), 0) from Reservation r")
    Long findMaxIdReservation();
}
