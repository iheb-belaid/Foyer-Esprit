package org.example.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Etudiant;
import org.example.foyer.Entities.Reservation;
import org.example.foyer.Repositories.EtudiantRepo;
import org.example.foyer.Repositories.ReservationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;
    private final ReservationRepo reservationRepo; // 🔥 AJOUT IMPORTANT

    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }

    @Override
    public long countEtudiantsByDateAndEcole(LocalDate date, String ecole) {
        return etudiantRepo.countByDateNaissanceAfterAndEcole(date, ecole);
    }

    // ✅ CAS 3 : Affecter Etudiant à Reservation
    @Override
    public void assignEtudiantToReservation(Long etudiantId, Long reservationId) {

        Etudiant etudiant = etudiantRepo.findById(etudiantId).get();
        Reservation reservation = reservationRepo.findById(reservationId).get();

        reservation.getEtudiants().add(etudiant);
        reservationRepo.save(reservation);
    }

    // ✅ CAS 6 : Désaffecter Etudiant d’une Reservation
    @Override
    public void desaffecterEtudiantFromReservation(Long etudiantId, Long reservationId) {

        Etudiant etudiant = etudiantRepo.findById(etudiantId).get();
        Reservation reservation = reservationRepo.findById(reservationId).get();

        reservation.getEtudiants().remove(etudiant);
        reservationRepo.save(reservation);
    }
}