package tn.esprit.examanspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.entities.Utilisateur;
import tn.esprit.examanspring.entities.Role;
import tn.esprit.examanspring.repository.EvenementRepository;
import tn.esprit.examanspring.repository.UtilisateurRepository;

@Service
public class EvenementService implements EvenementInterface {
    
    @Autowired
    private EvenementRepository evenementRepository;
    
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    
    @Override
    public Evenement addEvenement(Evenement e) {
        return evenementRepository.save(e);
    }
    
    @Override
    public String addUser(Utilisateur u, Long idEvent) {
        Evenement evenement = evenementRepository.findById(idEvent)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec l'ID: " + idEvent));
        
        utilisateurRepository.save(u);
        
    
        if (u.getRole() == Role.RESPONSABLE) {
            if (evenement.getResponsable() != null) {
                return "Il y a déjà un responsable !";
            }
            evenement.setResponsable(u);
            evenementRepository.save(evenement);
            return "L'affectation du responsable est effectuée avec succès";
        }
        
        if (u.getRole() == Role.PARTICIPANT) {
            Long nbParticipantsActuel = (long) evenement.getParticipants().size();
            if (evenement.getNbParticipants() != null && nbParticipantsActuel >= evenement.getNbParticipants()) {
                return "l'évènement est complet !";
            }       
            evenement.getParticipants().add(u);
            evenementRepository.save(evenement);
            return "L'affectation du participant est effectuée avec succès";
        }
        
        return "Rôle non reconnu";
    }
}
