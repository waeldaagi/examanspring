package tn.esprit.examanspring.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.entities.Utilisateur;
import tn.esprit.examanspring.service.EvenementInterface;
import java.util.List;

@RestController
public class EvenementRestController {
    
    EvenementInterface evenementInterface;
    
    public EvenementRestController(EvenementInterface evenementInterface) {
        this.evenementInterface = evenementInterface;
    }
    
    @PostMapping("/addevent")
    public Evenement addEvenement(@RequestBody Evenement evenement) {
        return evenementInterface.addEvenement(evenement);
    }
    
    @PostMapping("/adduser/{idEvent}")
    public String addUser(@RequestBody Utilisateur u, @PathVariable Long idEvent) {
        return evenementInterface.addUser(u, idEvent);
    }
    
    @GetMapping("/events/responsable/{responsableId}")
    public List<Evenement> getEventsByResponsable(@PathVariable Long responsableId) {
        return evenementInterface.getEventsByResponsable(responsableId);
    }
}
