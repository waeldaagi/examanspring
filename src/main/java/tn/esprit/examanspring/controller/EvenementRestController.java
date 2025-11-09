package tn.esprit.examanspring.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.examanspring.entities.Evenement;
import tn.esprit.examanspring.service.EvenementInterface;

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
}
