package tn.esprit.foyer.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.foyer.Entities.Bloc;
import tn.esprit.foyer.Service.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/api/bloc")
public class BlocController {

    private final IBlocService iblocService;

    public BlocController(IBlocService iblocService) {
        this.iblocService = iblocService;
    }

    @PostMapping("/addBloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return iblocService.addBloc(b);
    }

    @GetMapping("/retrieveAllBlocs")
    public List<Bloc> retrieveAllBlocs() {
        return iblocService.retrieveAllBlocs();
    }

    @GetMapping("/retrieveBloc/{id}")
    public Bloc retrieveBloc(@PathVariable("id") Long idBloc) {
        return iblocService.retrieveBloc(idBloc);
    }

    @PutMapping("/modifyBloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return iblocService.modifyBloc(bloc);
    }

    @DeleteMapping("/removeBloc/{id}")
    public void removeBloc(@PathVariable("id") Long idBloc) {
        iblocService.removeBloc(idBloc);
    }
}
