package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Universite;
import tn.esprit.foyer.Repositories.UniversiteRepo;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepo universiteRepo;

    public UniversiteServiceImpl(UniversiteRepo universiteRepo) {
        this.universiteRepo = universiteRepo;
    }

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepo.findById(idUniversite).get();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepo.save(u);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }
}
