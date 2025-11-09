package tn.esprit.examanspring.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.examanspring.entities.Activite;
import tn.esprit.examanspring.service.ActiviteInterface;

@RestController
public class ActiviteRestController {
    
    ActiviteInterface activiteInterface;
    
    public ActiviteRestController(ActiviteInterface activiteInterface) {
        this.activiteInterface = activiteInterface;
    }
    
    @PostMapping("/addactivite")
    public Activite addActivite(@RequestBody Activite activite) {
        return activiteInterface.addActivite(activite);
    }
    
    @PutMapping("/affect/{activiteId}/{eventId}")
    public void affectActiviteToEvent(@PathVariable Long activiteId, @PathVariable Long eventId) {
        activiteInterface.affectActiviteToEvent(activiteId, eventId);
    }
}