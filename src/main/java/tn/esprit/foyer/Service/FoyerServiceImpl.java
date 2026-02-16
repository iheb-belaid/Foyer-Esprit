package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Foyer;
import tn.esprit.foyer.Repositories.FoyerRepo;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepo foyerRepo;

    public FoyerServiceImpl(FoyerRepo foyerRepo) {
        this.foyerRepo = foyerRepo;
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepo.findById(idFoyer).get();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepo.save(f);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }
}
