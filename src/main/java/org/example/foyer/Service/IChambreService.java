package org.example.foyer.Service;

import org.example.foyer.Entities.Bloc;
import org.example.foyer.Entities.Chambre;
import org.example.foyer.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambre();
    public Chambre retrieveChambre(Long idChambre);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long idChambre);
    public Chambre modifyChambre(Chambre chambre);
    List<Chambre> findByTypeAndNumero(TypeChambre typec, Long numeroChambre);
    List<Chambre> getChambresParNomUniversite(String nomUniversite);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
    List<Chambre> getChambresParBlocEtTypeJPQL(long idBloc, TypeChambre typeC);
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
}
