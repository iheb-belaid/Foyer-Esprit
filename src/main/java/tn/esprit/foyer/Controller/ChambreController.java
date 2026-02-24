package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import tn.esprit.foyer.Entities.Chambre;
import tn.esprit.foyer.Service.IchambreService;

import java.util.List;

@RestController
@RequestMapping("/api/chambre")
public class ChambreController {
    private final IchambreService ichambreService;

    public ChambreController(IchambreService ichambreService) {
        this.ichambreService = ichambreService;
    }

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return ichambreService.addChambre(c);
    }

    @GetMapping("/retrieveAllChambres")
    public List<Chambre> retrieveAllChambres() {
        return ichambreService.retrieveAllChambre();
    }

    @GetMapping("/retrieveChambre/{id}")
    public Chambre retrieveChambre(@PathVariable("id") Long idChambre) {
        return ichambreService.retrieveChambre(idChambre);
    }

    @PutMapping("/modifyChambre")
    public Chambre modifyChambre(@RequestBody Chambre chambre) {
        return ichambreService.modifyChambre(chambre);
    }

    @DeleteMapping("/removeChambre/{id}")
    public void removeChambre(@PathVariable("id") Long idChambre) {
        ichambreService.removeChambre(idChambre);
    }
}
