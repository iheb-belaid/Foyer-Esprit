package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.Entities.Universite;
import tn.esprit.foyer.Service.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/api/universite")
public class UniversiteController {

    private final IUniversiteService iuniversiteService;

    public UniversiteController(IUniversiteService iuniversiteService) {
        this.iuniversiteService = iuniversiteService;
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return iuniversiteService.addUniversite(u);
    }

    @GetMapping("/retrieveAllUniversites")
    public List<Universite> retrieveAllUniversites() {
        return iuniversiteService.retrieveAllUniversites();
    }

    @GetMapping("/retrieveUniversite/{id}")
    public Universite retrieveUniversite(@PathVariable("id") Long idUniversite) {
        return iuniversiteService.retrieveUniversite(idUniversite);
    }

    @PutMapping("/modifyUniversite")
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return iuniversiteService.modifyUniversite(universite);
    }

    @DeleteMapping("/removeUniversite/{id}")
    public void removeUniversite(@PathVariable("id") Long idUniversite) {
        iuniversiteService.removeUniversite(idUniversite);
    }
}
