package org.example.foyer.Service;

import org.example.foyer.Entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationService {

    List<Reservation> retrieveAllReservation();

    Reservation retrieveReservation(long idReservation);

    Reservation addReservation(Reservation reservation);

    void removeReservation(long idReservation);

    Reservation modifyReservation(Reservation reservation);

    List<Reservation> findValidReservationsByAnnee(LocalDate anneeUniversitaire);

    Reservation ajouterReservation(long idBloc, long cinEtudiant);

    Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite);
}
