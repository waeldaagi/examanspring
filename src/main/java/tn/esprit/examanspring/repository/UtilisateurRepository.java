package tn.esprit.examanspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examanspring.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}

