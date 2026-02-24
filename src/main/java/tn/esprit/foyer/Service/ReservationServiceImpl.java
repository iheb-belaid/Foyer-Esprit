package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Reservation;
import tn.esprit.foyer.Repositories.ReservationRepo;

import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepo reservationRepo;

    public ReservationServiceImpl(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        return reservationRepo.findById(idReservation).get();
    }

    @Override
    public Reservation addReservation(Reservation r) {
        if (r.getIdReservation() == null) {
            Long maxId = reservationRepo.findMaxIdReservation();
            r.setIdReservation(maxId + 1);
        }
        return reservationRepo.save(r);
    }

    @Override
    public void removeReservation(Long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
}
