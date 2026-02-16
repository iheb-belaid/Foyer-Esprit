package tn.esprit.foyer.Service;

import org.springframework.stereotype.Service;
import tn.esprit.foyer.Entities.Bloc;
import tn.esprit.foyer.Repositories.BlocRepo;

import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {

    private final BlocRepo blocRepo;

    public BlocServiceImpl(BlocRepo blocRepo) {
        this.blocRepo = blocRepo;
    }

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepo.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepo.findById(idBloc).get();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc modifyBloc(Bloc bloc) {
        return blocRepo.save(bloc);
    }
}
