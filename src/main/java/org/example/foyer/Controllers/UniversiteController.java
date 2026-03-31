package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Universite;
import org.example.foyer.Service.IUniversiteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Universite")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/universite")
public class UniversiteController {

    private final IUniversiteService universiteService;
    @Operation(description = "ajouter une universite à la base de données")

    @PostMapping("/addUniversite")
    public Universite ajouterUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }
    @Operation(description = "récupérer toutes les universites de la base de données")


    @GetMapping("/getAll")
    public List<Universite> getAllUniversites() {
        return universiteService.retrieveAllUniversite();
    }

    @GetMapping("/get/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return universiteService.retrieveUniversite(id);
    }

    @PutMapping("/update")
    public Universite modifierUniversite(@RequestBody Universite universite) {
        return universiteService.modifyUniversite(universite);
    }
    @Operation(description = "supprimer une universite de la base de données")

    @DeleteMapping("/delete/{id}")
    public void supprimerUniversite(@PathVariable Long id) {
        universiteService.removeUniversite(id);
    }

    @Operation(description = "ajouter une universite avec son foyer")
    @PostMapping("/addUniversiteWithFoyer")
    public Universite ajouterUniversiteAvecFoyer(@RequestBody Universite universite) {
        return universiteService.addUniversiteAndFoyerAndAssign(universite);
    }


    // CAS 2
    @PutMapping("/assignFoyer/{universiteId}/{foyerId}")
    public void affecterFoyer(
            @PathVariable Long universiteId,
            @PathVariable Long foyerId) {

        universiteService.assignFoyerToUniversite(universiteId, foyerId);
    }

    // CAS 4
    @PostMapping("/createAndAssign/{foyerId}")
    public Universite createAndAssign(
            @RequestBody Universite universite,
            @PathVariable Long foyerId) {

        return universiteService.addUniversiteAndAssignFoyerToUniversite(universite, foyerId);
    }

    // CAS 5
    @PutMapping("/desaffecterFoyer/{universiteId}")
    public Universite desaffecterFoyer(@PathVariable Long universiteId) {

        return universiteService.desaffecterFoyerFromUniversite(universiteId);
    }

    @Operation(description = "desaffecter un foyer d'une universite")
    @PutMapping("/desaffecterFoyerAUniversite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyer(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite) {

        return universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
}
