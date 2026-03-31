package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Chambre;
import org.example.foyer.Entities.TypeChambre;
import org.example.foyer.Repositories.ChambreRepo;
import org.example.foyer.Service.IChambreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Chambre")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chambre")

public class ChambreController {
    private final IChambreService chambreService;

    @PostMapping ("/addChambre")
        public Chambre ajouterChambre(@RequestBody Chambre chambre) {

        return chambreService.addChambre(chambre);
    }
    @Operation(description = "récupérer toutes les chambres de la base de données")

    @GetMapping("/getAll")
    public List<Chambre> getAllChambres() {
        return chambreService.retrieveAllChambre();
    }
    @GetMapping("/get/{id}")
    public Chambre getChambre(@PathVariable Long id) {
        return chambreService.retrieveChambre(id);
    }
    @PutMapping("/update")
    public Chambre modifierChambre(@RequestBody Chambre chambre) {
        return chambreService.modifyChambre(chambre);
    }
    @DeleteMapping("/delete/{id}")
    public void supprimerChambre(@PathVariable Long id) {
        chambreService.removeChambre(id);
    }

    @GetMapping("/search/{type}/{numero}")
    public List<Chambre> rechercherParTypeEtNumero(@PathVariable TypeChambre type,
                                                   @PathVariable Long numero) {
        return chambreService.findByTypeAndNumero(type, numero);
    }

    @Operation(description = "afficher les chambres d'une universite a partir de son nom")
    @GetMapping("/universite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @Operation(description = "lister les chambres d'un bloc selon un type (solution Keywords)")
    @GetMapping("/bloc/{idBloc}/type/{typeC}")
    public List<Chambre> getChambresParBlocEtType(
            @PathVariable long idBloc,
            @PathVariable TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }

    @Operation(description = "lister les chambres d'un bloc selon un type (solution JPQL)")
    @GetMapping("/bloc/{idBloc}/type/{typeC}/jpql")
    public List<Chambre> getChambresParBlocEtTypeJPQL(
            @PathVariable long idBloc,
            @PathVariable TypeChambre typeC) {
        return chambreService.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }

    @Operation(description = "afficher les chambres non reservees de l'annee universitaire actuelle par universite et type")
    @GetMapping("/non-reservees/universite/{nomUniversite}/type/{type}")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @PathVariable String nomUniversite,
            @PathVariable TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}
