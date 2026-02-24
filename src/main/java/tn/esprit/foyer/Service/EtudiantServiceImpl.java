package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Etudiant;
import tn.esprit.foyer.Repositories.EtudiantRepo;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;

    public EtudiantServiceImpl(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepo.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepo.findById(idEtudiant).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepo.save(e);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etudiantRepo.deleteById(idEtudiant);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepo.save(etudiant);
    }
}
