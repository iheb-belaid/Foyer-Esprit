package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entities.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();

    public Foyer retrieveFoyer(Long idFoyer);

    public Foyer addFoyer(Foyer f);

    public void removeFoyer(Long idFoyer);

    public Foyer modifyFoyer(Foyer foyer);
}
