package tn.esprit.examanspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examanspring.entities.Activite;
import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.repository.ActiviteRepository;
import tn.esprit.examanspring.repository.EvenementRepository;

@Service
public class ActiviteService implements ActiviteInterface {
    
    @Autowired
    private ActiviteRepository activiteRepository;
    
    @Autowired
    private EvenementRepository evenementRepository;
    
    @Override
    public Activite addActivite(Activite a) {
        return activiteRepository.save(a);
    }
    
    @Override
    public void affectActiviteToEvent(Long activiteId, Long eventId) {
        Activite activite = activiteRepository.findById(activiteId)
                .orElseThrow(() -> new RuntimeException("Activité non trouvée avec l'ID: " + activiteId));
        Evenement evenement = evenementRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec l'ID: " + eventId));
        
        activite.setEvenement(evenement);
        activiteRepository.save(activite);
    }
}
