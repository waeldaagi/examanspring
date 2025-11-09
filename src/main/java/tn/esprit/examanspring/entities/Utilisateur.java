package tn.esprit.examanspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;


import tn.esprit.examanspring.entities.Role;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idU;
    private String nom;
    private String prenom;
    private Long numTelephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Relation bidirectionnelle: Un responsable peut gérer plusieurs évènements
    @OneToMany(mappedBy = "responsable")
    private Set<Evenement> evenementsGeres = new HashSet<>();

    // Relation bidirectionnelle: Un participant peut participer à plusieurs évènements
    @ManyToMany(mappedBy = "participants")
    private Set<Evenement> evenementsParticipes = new HashSet<>();
}
