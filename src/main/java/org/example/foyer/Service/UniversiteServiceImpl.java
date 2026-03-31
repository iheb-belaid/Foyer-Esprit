package org.example.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Universite;
import org.example.foyer.Repositories.UniversiteRepo;
import org.springframework.stereotype.Service;
import org.example.foyer.Repositories.FoyerRepo;
import org.example.foyer.Entities.Foyer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepo universiteRepo;
    private final FoyerRepo foyerRepo;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepo.findAll();
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepo.findById(idUniversite).get();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }

    @Override
    public void removeUniversite(Long idUniversite) {
        universiteRepo.deleteById(idUniversite);
    }

    @Override
    public Universite modifyUniversite(Universite universite) {
        return universiteRepo.save(universite);
    }

    @Override
    public Universite addUniversiteAndFoyerAndAssign(Universite universite) {
        return universiteRepo.save(universite);
    }

    // CAS 2
    @Override
    public void assignFoyerToUniversite(Long universiteId, Long foyerId) {

        Universite universite = universiteRepo.findById(universiteId).get();
        Foyer foyer = foyerRepo.findById(foyerId).get();

        universite.setFoyer(foyer);
        universiteRepo.save(universite);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = universiteRepo.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepo.findById(idFoyer).get();

        universite.setFoyer(foyer);
        return universiteRepo.save(universite);
    }

    @Override
    public Universite addUniversiteAndAssignFoyerToUniversite(Universite universite, Long foyerId) {

        Foyer foyer = foyerRepo.findById(foyerId).get();
        universite.setFoyer(foyer);

        return universiteRepo.save(universite);
    }




    @Override
    public Universite desaffecterFoyerFromUniversite(Long universiteId) {

        Universite universite = universiteRepo.findById(universiteId).get();
        universite.setFoyer(null);

        return universiteRepo.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepo.findById(idUniversite).get();
        universite.setFoyer(null);
        return universiteRepo.save(universite);
    }
}
