package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Reservation;
import org.example.foyer.Service.IReservationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {

    private final IReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/getAll")
    public List<Reservation> getAllReservations() {
        return reservationService.retrieveAllReservation();
    }

    @GetMapping("/get/{id}")
    public Reservation getReservation(@PathVariable long id) {
        return reservationService.retrieveReservation(id);
    }

    @PutMapping("/update")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifyReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerReservation(@PathVariable long id) {
        reservationService.removeReservation(id);
    }

    @GetMapping("/valid/{annee}")
    public List<Reservation> getValidReservationsByAnnee(@PathVariable String annee) {
        return reservationService.findValidReservationsByAnnee(LocalDate.parse(annee));
    }

    @Operation(description = "ajouter une reservation et l'affecter a une chambre d'un bloc et a un etudiant")
    @PostMapping("/ajouterReservation/{idBloc}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable long idBloc, @PathVariable long cinEtudiant) {
        return reservationService.ajouterReservation(idBloc, cinEtudiant);
    }

    @Operation(description = "annuler une reservation selon le cin d'un etudiant")
    @PutMapping("/annulerReservation/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }

    @Operation(description = "afficher les reservations d'une universite pour une annee universitaire donnee")
    @GetMapping("/universite/{nomUniversite}/annee")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date anneeUniversite,
            @PathVariable String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }
}
