package tn.esprit.examanspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.repository.EvenementRepository;

@Service
public class EvenementService implements EvenementInterface {
    
    @Autowired
    private EvenementRepository evenementRepository;
    
    @Override
    public Evenement addEvenement(Evenement e) {
        return evenementRepository.save(e);
    }
}
