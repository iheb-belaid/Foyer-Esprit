package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entities.Bloc;
import tn.esprit.foyer.Entities.Chambre;

import java.util.List;

public interface IchambreService {
    public List<Chambre> retrieveAllChambre();

    public Chambre retrieveChambre(Long idChambre);

    public Chambre addChambre(Chambre c);

    public void removeChambre(Long idChambre);

    public Chambre modifyChambre(Chambre chambre);


}
