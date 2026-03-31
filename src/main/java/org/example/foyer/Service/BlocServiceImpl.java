package org.example.foyer.Service;

import lombok.RequiredArgsConstructor;
import org.example.foyer.Entities.Bloc;
import org.example.foyer.Entities.Chambre;
import org.example.foyer.Repositories.BlocRepo;
import org.example.foyer.Repositories.ChambreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private final BlocRepo blocRepo;
    private final ChambreRepo chambreRepo;

    @Override
    public List<Bloc> retrieveAllBloc() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepo.findById(idBloc).get();
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepo.findById(idBloc).get();
        List<Chambre> chambres = chambreRepo.findByNumeroChambreIn(numChambre);

        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        chambreRepo.saveAll(chambres);
        return bloc;
    }
}
