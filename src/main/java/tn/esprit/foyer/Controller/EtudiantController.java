package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.Entities.Etudiant;
import tn.esprit.foyer.Service.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    private final IEtudiantService ietudiantService;

    public EtudiantController(IEtudiantService ietudiantService) {
        this.ietudiantService = ietudiantService;
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return ietudiantService.addEtudiant(e);
    }

    @GetMapping("/retrieveAllEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return ietudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/retrieveEtudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id") Long idEtudiant) {
        return ietudiantService.retrieveEtudiant(idEtudiant);
    }

    @PutMapping("/modifyEtudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant) {
        return ietudiantService.modifyEtudiant(etudiant);
    }

    @DeleteMapping("/removeEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id") Long idEtudiant) {
        ietudiantService.removeEtudiant(idEtudiant);
    }
}
