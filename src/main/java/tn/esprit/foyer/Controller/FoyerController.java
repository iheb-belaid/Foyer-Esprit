package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.Entities.Foyer;
import tn.esprit.foyer.Service.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/api/foyer")
public class FoyerController {

    private final IFoyerService ifoyerService;

    public FoyerController(IFoyerService ifoyerService) {
        this.ifoyerService = ifoyerService;
    }

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return ifoyerService.addFoyer(f);
    }

    @GetMapping("/retrieveAllFoyers")
    public List<Foyer> retrieveAllFoyers() {
        return ifoyerService.retrieveAllFoyers();
    }

    @GetMapping("/retrieveFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable("id") Long idFoyer) {
        return ifoyerService.retrieveFoyer(idFoyer);
    }

    @PutMapping("/modifyFoyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        return ifoyerService.modifyFoyer(foyer);
    }

    @DeleteMapping("/removeFoyer/{id}")
    public void removeFoyer(@PathVariable("id") Long idFoyer) {
        ifoyerService.removeFoyer(idFoyer);
    }
}
