package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entities.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();

    public Bloc retrieveBloc(Long idBloc);

    public Bloc addBloc(Bloc b);

    public void removeBloc(Long idBloc);

    public Bloc modifyBloc(Bloc bloc);
}
