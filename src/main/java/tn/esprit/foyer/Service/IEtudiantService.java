package tn.esprit.foyer.Service;

import tn.esprit.foyer.Entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();

    public Etudiant retrieveEtudiant(Long idEtudiant);

    public Etudiant addEtudiant(Etudiant e);

    public void removeEtudiant(Long idEtudiant);

    public Etudiant modifyEtudiant(Etudiant etudiant);
}
