package tn.esprit.examanspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    private String libelle;
    private String description;
    
    @Temporal(TemporalType.DATE)
    private Date dateEvent;
    
    private Long nbParticipants;

    // Relation bidirectionnelle: Un responsable peut gérer plusieurs évènements
    // Un évènement peut être géré qu'avec un seul responsable
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Utilisateur responsable;

    // Relation bidirectionnelle: Un participant peut participer à plusieurs évènements
    // Un évènement peut contenir plusieurs participants (Evènement est le child/propriétaire)
    @ManyToMany
    @JoinTable(
        name = "evenement_participants",
        joinColumns = @JoinColumn(name = "evenement_id"),
        inverseJoinColumns = @JoinColumn(name = "utilisateur_id")
    )
    private Set<Utilisateur> participants = new HashSet<>();

    // Relation bidirectionnelle: Un évènement peut avoir plusieurs activités
    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private Set<Activite> activites = new HashSet<>();
}
