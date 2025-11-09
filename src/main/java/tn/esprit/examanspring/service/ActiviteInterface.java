package tn.esprit.examanspring.service;

import tn.esprit.examanspring.entities.Activite;

public interface ActiviteInterface {
    Activite addActivite(Activite a);
    void affectActiviteToEvent(Long activiteId, Long eventId);
}
