package tn.esprit.examanspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examanspring.entities.Evenement;
import java.util.List;


public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findByResponsable_IdU(Long responsableId);
}
