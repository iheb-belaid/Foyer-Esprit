package org.example.foyer.Repositories;

import org.example.foyer.Entities.Chambre;
import org.example.foyer.Entities.TypeChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ChambreRepo extends JpaRepository<Chambre, Long> {
    List<Chambre> findByTypecAndNumeroChambre(TypeChambre typec, Long numeroChambre);
    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambre);
    List<Chambre> findByBloc_IdBloc(Long idBloc);
    List<Chambre> findByBloc_IdBlocAndTypec(Long idBloc, TypeChambre typec);
    List<Chambre> findByReservations_IdReservation(Long idReservation);

    @Query("select c from Chambre c " +
            "join c.bloc b " +
            "join b.foyer f " +
            "join f.universite u " +
            "where u.nomUniversite = :nomUniversite")
    List<Chambre> getChambresParNomUniversite(@Param("nomUniversite") String nomUniversite);

    @Query("select c from Chambre c where c.bloc.idBloc = :idBloc and c.typec = :typeC")
    List<Chambre> getChambresParBlocEtTypeJPQL(@Param("idBloc") Long idBloc, @Param("typeC") TypeChambre typeC);

    @Query("select c from Chambre c " +
            "join c.bloc b " +
            "join b.foyer f " +
            "join f.universite u " +
            "where u.nomUniversite = :nomUniversite " +
            "and c.typec = :type " +
            "and not exists (" +
            "   select 1 from Chambre c2 join c2.reservations r " +
            "   where c2.idChambre = c.idChambre " +
            "   and function('year', r.anneeUniversitaire) = :anneeActuelle " +
            "   and r.estValide = true" +
            ")")
    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            @Param("nomUniversite") String nomUniversite,
            @Param("type") TypeChambre type,
            @Param("anneeActuelle") int anneeActuelle);
}
