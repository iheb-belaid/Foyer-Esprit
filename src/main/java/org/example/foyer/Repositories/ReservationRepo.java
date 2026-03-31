package org.example.foyer.Repositories;

import org.example.foyer.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    List<Reservation> findByAnneeUniversitaireAndEstValideTrue(LocalDate anneeUniversitaire);
    Reservation findTopByOrderByIdReservationDesc();
    Optional<Reservation> findFirstByEtudiants_CinAndEstValideTrue(Long cin);

    @Query("select distinct r from Chambre c " +
            "join c.reservations r " +
            "join c.bloc b " +
            "join b.foyer f " +
            "join f.universite u " +
            "where function('year', r.anneeUniversitaire) = :annee " +
            "and u.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(
            @Param("annee") int annee,
            @Param("nomUniversite") String nomUniversite);
}
