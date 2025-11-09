package tn.esprit.examanspring.service;

import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.entities.Utilisateur;

public interface EvenementInterface {
    Evenement addEvenement(Evenement e);
    String addUser(Utilisateur u, Long idEvent);
}
