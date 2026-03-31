package org.example.foyer.Service;

import org.example.foyer.Entities.Universite;

import java.util.List;

public interface IUniversiteService {

    List<Universite> retrieveAllUniversite();

    Universite retrieveUniversite(Long idUniversite);

    Universite addUniversite(Universite universite);

    void removeUniversite(Long idUniversite);

    Universite modifyUniversite(Universite universite);

    Universite addUniversiteAndFoyerAndAssign(Universite universite);

    void assignFoyerToUniversite(Long universiteId, Long foyerId);

    // CAS 4
    Universite addUniversiteAndAssignFoyerToUniversite(Universite universite, Long foyerId);

    public Universite affecterFoyerAUniversite (long idFoyer, String
            nomUniversite) ;

    // CAS 5
    Universite desaffecterFoyerFromUniversite(Long universiteId);

    // CAS 6
    Universite desaffecterFoyerAUniversite(long idUniversite);
}
