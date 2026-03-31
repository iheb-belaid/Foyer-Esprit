package org.example.foyer.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.foyer.Entities.Chambre;
import org.example.foyer.Entities.TypeChambre;
import org.example.foyer.Repositories.ChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ChambreServiceImpl implements IChambreService {
    private final ChambreRepo chambreRepo;

    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepo.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepo.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepo.findById(idChambre).get();
    }

    @Override
    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepo.save(chambre);
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepo.deleteById(idChambre);

    }
    @Override
    public List<Chambre> findByTypeAndNumero(TypeChambre typec, Long numeroChambre) {
        return chambreRepo.findByTypecAndNumeroChambre(typec, numeroChambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepo.getChambresParNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepo.findByBloc_IdBlocAndTypec(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC) {
        return chambreRepo.getChambresParBlocEtTypeJPQL(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type) {
        int anneeActuelle = LocalDate.now().getYear();
        return chambreRepo.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type, anneeActuelle);
    }

}
