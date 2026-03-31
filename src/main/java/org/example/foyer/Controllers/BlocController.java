package org.example.foyer.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Bloc;
import org.example.foyer.Service.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Gestion Bloc")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bloc")
public class BlocController {

    private final IBlocService blocService;

    @PostMapping("/addBloc")
    public Bloc ajouterBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }
    @Operation(description = "récupérer tous les blocs de la base de données")

    @GetMapping("/getAll")
    public List<Bloc> getAllBlocs() {
        return blocService.retrieveAllBloc();
    }

    @GetMapping("/get/{id}")
    public Bloc getBloc(@PathVariable Long id) {
        return blocService.retrieveBloc(id);
    }

    @PutMapping("/update")
    public Bloc modifierBloc(@RequestBody Bloc bloc) {
        return blocService.modifyBloc(bloc);
    }
    @Operation(description = "supprimer un bloc de la base de données")

    @DeleteMapping("/delete/{id}")
    public void supprimerBloc(@PathVariable Long id) {
        blocService.removeBloc(id);
    }

    @Operation(description = "affecter une liste de chambres a un bloc")
    @PutMapping("/affecterChambresABloc/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }
}
