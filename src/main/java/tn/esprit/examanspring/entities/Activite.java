package tn.esprit.examanspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idA;
    private String libelle;
    private String description;

    // Relation bidirectionnelle: Un évènement peut avoir plusieurs activités
    // Une activité peut être affectée qu'à un seul évènement
    @ManyToOne
    @JoinColumn(name = "evenement_id")
    private Evenement evenement;
}
