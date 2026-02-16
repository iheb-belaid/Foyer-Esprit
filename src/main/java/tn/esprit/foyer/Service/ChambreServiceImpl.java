package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Chambre;
import tn.esprit.foyer.Repositories.ChambreRepo;

import java.util.List;

@Service
public class ChambreServiceImpl implements IchambreService {

    private final ChambreRepo chambreRepo;

    public ChambreServiceImpl(ChambreRepo chambreRepo) {
        this.chambreRepo = chambreRepo;
    }

    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepo.findById(idChambre).get();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);  }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }
}
