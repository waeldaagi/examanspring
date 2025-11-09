package tn.esprit.examanspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.examanspring.entities.Evenement;


public interface EvenementRepository extends JpaRepository<Evenement, Long> {

}
