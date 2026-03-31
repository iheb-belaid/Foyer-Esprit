package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Foyer;
import org.example.foyer.Service.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Foyer")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/foyer")
public class FoyerController {

    private final IFoyerService foyerService;
    @Operation(description = "ajouter un foyer à la base de données")

    @PostMapping("/addFoyer")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping("/getAll")
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyer();
    }

    @GetMapping("/get/{id}")
    public Foyer getFoyer(@PathVariable Long id) {
        return foyerService.retrieveFoyer(id);
    }
    @Operation(description = "modifier un foyer dans la base de données")

    @PutMapping("/update")
    public Foyer modifierFoyer(@RequestBody Foyer foyer) {
        return foyerService.modifyFoyer(foyer);
    }
    @Operation(description = "supprimer un foyer de la base de données")

    @DeleteMapping("/delete/{id}")
    public void supprimerFoyer(@PathVariable Long id) {
        foyerService.removeFoyer(id);
    }

    @GetMapping("/nom/{nom}")
    public Foyer getByNom(@PathVariable String nom) {
        return foyerService.findByNomFoyer(nom);
    }

    @GetMapping("/search/{nom}/{capacite}")
    public List<Foyer> rechercherParNomEtCapacite(@PathVariable String nom,
                                                  @PathVariable long capacite) {
        return foyerService.findByNomAndCapacite(nom, capacite);
    }

    @Operation(description = "ajouter un foyer avec ses blocs et l'affecter a une universite")
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(
            @RequestBody Foyer foyer,
            @PathVariable long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
