package org.example.foyer.Service;

import org.example.foyer.Entities.Etudiant;

import java.time.LocalDate;
import java.util.List;

public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiant();

    Etudiant retrieveEtudiant(Long idEtudiant);

    Etudiant addEtudiant(Etudiant etudiant);

    void removeEtudiant(Long idEtudiant);

    Etudiant modifyEtudiant(Etudiant etudiant);
    long countEtudiantsByDateAndEcole(LocalDate date, String ecole);

    // CAS 3
    void assignEtudiantToReservation(Long etudiantId, Long reservationId);

    // CAS 6
    void desaffecterEtudiantFromReservation(Long etudiantId, Long reservationId);

}
