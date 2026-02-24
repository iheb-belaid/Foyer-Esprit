package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entities.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();

    public Reservation retrieveReservation(Long idReservation);

    public Reservation addReservation(Reservation r);

    public void removeReservation(Long idReservation);

    public Reservation modifyReservation(Reservation reservation);
}
