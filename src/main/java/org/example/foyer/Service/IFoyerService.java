package org.example.foyer.Service;

import org.example.foyer.Entities.Foyer;

import java.util.List;

public interface IFoyerService {

    List<Foyer> retrieveAllFoyer();

    Foyer retrieveFoyer(Long idFoyer);

    Foyer addFoyer(Foyer foyer);

    void removeFoyer(Long idFoyer);

    Foyer modifyFoyer(Foyer foyer);

    Foyer findByNomFoyer(String nomFoyer);

    List<Foyer> findByNomAndCapacite(String nomFoyer, long capaciteFoyer);




    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);


}
