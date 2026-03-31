package org.example.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Bloc;
import org.example.foyer.Entities.Foyer;
import org.example.foyer.Entities.Universite;
import org.example.foyer.Repositories.BlocRepo;
import org.example.foyer.Repositories.FoyerRepo;
import org.example.foyer.Repositories.UniversiteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepo foyerRepo;
    private final UniversiteRepo universiteRepo;
    private final BlocRepo blocRepo;

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepo.findAll();
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepo.findById(idFoyer).get();
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepo.deleteById(idFoyer);
    }

    @Override
    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer findByNomFoyer(String nomFoyer) {
        return foyerRepo.findByNomFoyer(nomFoyer);
    }

    @Override
    public List<Foyer> findByNomAndCapacite(String nomFoyer, long capaciteFoyer) {
        return foyerRepo.findByNomFoyerAndCapaciteFoyerLessThan(nomFoyer, capaciteFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).get();
        Foyer savedFoyer = foyerRepo.save(foyer);

        Set<Bloc> blocs = foyer.getBlocs();
        if (blocs != null && !blocs.isEmpty()) {
            for (Bloc bloc : blocs) {
                bloc.setFoyer(savedFoyer);
            }
            blocRepo.saveAll(blocs);
        }

        universite.setFoyer(savedFoyer);
        universiteRepo.save(universite);

        return savedFoyer;
    }

}
