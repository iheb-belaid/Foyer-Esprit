package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Etudiant;
import org.example.foyer.Service.IEtudiantService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private final IEtudiantService etudiantService;
    @Operation(description = "ajouter un étudiant à la base de données")

    @PostMapping("/addEtudiant")
    public Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }
    @Operation(description = "récupérer tous les étudiants de la base de données")

    @GetMapping("/getAll")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.retrieveAllEtudiant();
    }

    @GetMapping("/get/{id}")
    public Etudiant getEtudiant(@PathVariable Long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @PutMapping("/update")
    public Etudiant modifierEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.modifyEtudiant(etudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerEtudiant(@PathVariable Long id) {
        etudiantService.removeEtudiant(id);
    }

    @GetMapping("/count")
    @Operation(description = "Compter les étudiants nés après une date et appartenant à une école donnée")
    public long countEtudiants(
            @RequestParam String date,
            @RequestParam String ecole) {

        // convertir la date reçue en LocalDate
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return etudiantService.countEtudiantsByDateAndEcole(localDate, ecole);
    }

    @PutMapping("/assignEtudiantToReservation/{etudiantId}/{reservationId}")
    public void assignEtudiantToReservation(
            @PathVariable Long etudiantId,
            @PathVariable Long reservationId) {

        etudiantService.assignEtudiantToReservation(etudiantId, reservationId);
    }

    // CAS 6
    @PutMapping("/desaffecter/{etudiantId}/{reservationId}")
    public void desaffecterEtudiant(
            @PathVariable Long etudiantId,
            @PathVariable Long reservationId) {

        etudiantService.desaffecterEtudiantFromReservation(etudiantId, reservationId);
    }
}
