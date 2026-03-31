package org.example.foyer.Service;

import org.example.foyer.Entities.Bloc;

import java.util.List;

public interface IBlocService {

    List<Bloc> retrieveAllBloc();

    Bloc retrieveBloc(Long idBloc);

    Bloc addBloc(Bloc bloc);

    void removeBloc(Long idBloc);

    Bloc modifyBloc(Bloc bloc);

    Bloc affecterChambresABloc(List<Long> numChambre, long idBloc);
}
