package org.example.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Bloc;
import org.example.foyer.Entities.Chambre;
import org.example.foyer.Entities.Etudiant;
import org.example.foyer.Entities.Reservation;
import org.example.foyer.Entities.TypeChambre;
import org.example.foyer.Repositories.BlocRepo;
import org.example.foyer.Repositories.ChambreRepo;
import org.example.foyer.Repositories.EtudiantRepo;
import org.example.foyer.Repositories.ReservationRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepo reservationRepo;
    private final BlocRepo blocRepo;
    private final EtudiantRepo etudiantRepo;
    private final ChambreRepo chambreRepo;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepo.findAll();
    }

    @Override
    public Reservation retrieveReservation(long idReservation) {
        return reservationRepo.findById(idReservation).get();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public void removeReservation(long idReservation) {
        reservationRepo.deleteById(idReservation);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> findValidReservationsByAnnee(LocalDate anneeUniversitaire) {
        return reservationRepo.findByAnneeUniversitaireAndEstValideTrue(anneeUniversitaire);
    }

    @Override
    @Transactional
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        Bloc bloc = blocRepo.findById(idBloc)
                .orElseThrow(() -> new IllegalArgumentException("Bloc introuvable avec id " + idBloc));
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);

        if (etudiant == null) {
            throw new IllegalArgumentException("Aucun etudiant trouve avec ce CIN");
        }

        List<Chambre> chambresBloc = chambreRepo.findByBloc_IdBloc(bloc.getIdBloc());
        if (chambresBloc.isEmpty()) {
            throw new IllegalStateException("Aucune chambre n'est associee a ce bloc");
        }

        Chambre chambreDisponible = chambresBloc.stream()
                .sorted(Comparator.comparing(Chambre::getNumeroChambre))
                .filter(this::hasAvailableCapacity)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Aucune chambre disponible dans ce bloc"));

        Reservation reservation = new Reservation();
        Reservation lastReservation = reservationRepo.findTopByOrderByIdReservationDesc();
        long nextId = lastReservation == null ? 1L : lastReservation.getIdReservation() + 1L;
        reservation.setIdReservation(nextId);
        reservation.setEstValide(true);
        reservation.setAnneeUniversitaire(LocalDate.now());

        String numReservation = chambreDisponible.getNumeroChambre() + "-" + bloc.getNomBloc() + "-"
                + reservation.getAnneeUniversitaire().getYear();
        reservation.setNumReservation(numReservation);
        reservation.getEtudiants().add(etudiant);

        Reservation savedReservation = reservationRepo.save(reservation);

        if (chambreDisponible.getReservations() == null) {
            chambreDisponible.setReservations(new HashSet<>());
        }
        chambreDisponible.getReservations().add(savedReservation);
        chambreRepo.save(chambreDisponible);

        return savedReservation;
    }

    @Override
    @Transactional
    public Reservation annulerReservation(long cinEtudiant) {
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new IllegalArgumentException("Aucun etudiant trouve avec ce CIN");
        }

        Reservation reservation = reservationRepo.findFirstByEtudiants_CinAndEstValideTrue(cinEtudiant)
                .orElseThrow(() -> new IllegalStateException("Aucune reservation valide trouvee pour cet etudiant"));

        reservation.setEstValide(false);
        reservation.getEtudiants().removeIf(e -> Objects.equals(e.getCin(), cinEtudiant));
        Reservation savedReservation = reservationRepo.save(reservation);

        List<Chambre> chambres = chambreRepo.findByReservations_IdReservation(savedReservation.getIdReservation());
        for (Chambre chambre : chambres) {
            if (chambre.getReservations() != null) {
                chambre.getReservations().removeIf(r -> Objects.equals(r.getIdReservation(), savedReservation.getIdReservation()));
            }
        }
        chambreRepo.saveAll(chambres);

        return savedReservation;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {
        if (anneeUniversite == null) {
            throw new IllegalArgumentException("L'annee universitaire est obligatoire");
        }
        if (nomUniversite == null || nomUniversite.isBlank()) {
            throw new IllegalArgumentException("Le nom de l'universite est obligatoire");
        }

        int annee = anneeUniversite.toInstant().atZone(ZoneId.systemDefault()).getYear();
        return reservationRepo.getReservationParAnneeUniversitaireEtNomUniversite(annee, nomUniversite);
    }

    private boolean hasAvailableCapacity(Chambre chambre) {
        int max = getMaxCapacity(chambre.getTypec());
        Set<Reservation> reservations = chambre.getReservations();
        long occupied = reservations == null ? 0 : reservations.stream().filter(Reservation::isEstValide).count();
        return occupied < max;
    }

    private int getMaxCapacity(TypeChambre typeChambre) {
        if (typeChambre == TypeChambre.SIMPLE) {
            return 1;
        }
        if (typeChambre == TypeChambre.DOUBLE) {
            return 2;
        }
        if (typeChambre == TypeChambre.TRIPLE) {
            return 3;
        }
        return 0;
    }
}
