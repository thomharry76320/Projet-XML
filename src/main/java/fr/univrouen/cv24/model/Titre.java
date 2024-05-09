package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Titre" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "titre")
@Entity
@Table(name = "titre")
public class Titre {

    /**
     * L'identifiant unique du titre.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /**
     * Le titre lui-même.
     */
    @Column(name = "titre", nullable = false)
    @XmlValue
    private String titre;

    /**
     * L'identifiant du diplôme auquel ce titre est associé.
     */
    @Column(name = "diplome_id", nullable = false)
    @XmlTransient
    private int diplomeid;

    // Getters et setters

    /**
     * Obtient l'identifiant unique du titre.
     *
     * @return L'identifiant du titre.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du titre.
     *
     * @param id Le nouvel identifiant du titre.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient le titre.
     *
     * @return Le titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre.
     *
     * @param titre Le nouveau titre.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient l'identifiant du diplôme associé à ce titre.
     *
     * @return L'identifiant du diplôme.
     */
    public int getDiplomeID() {
        return diplomeid;
    }

    /**
     * Définit l'identifiant du diplôme associé à ce titre.
     *
     * @param id Le nouvel identifiant du diplôme.
     */
    public void setDiplomeID(int id) {
        this.diplomeid = id;
    }
}
