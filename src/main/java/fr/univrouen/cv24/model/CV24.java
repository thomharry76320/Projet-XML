package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

/**
 * Cette classe représente une entité "CV24" dans le modèle CV.
 */
@Entity
@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "cv")
public class CV24 implements Serializable {

    /**
     * L'identifiant unique du CV.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /**
     * Les informations d'identité du cv.
     */
    @Transient
    @XmlElement(name = "identite", namespace = "http://univ.fr/cv24", required = true)
    private Identite identite;

    /**
     * Les informations professionnelles du cv.
     */
    @Transient
    @XmlElement(name = "prof", namespace = "http://univ.fr/cv24", nillable = true)
    private Prof prof;

    /**
     * L'objectif du cv.
     */
    @Transient
    @XmlElement(name = "objectif", namespace = "http://univ.fr/cv24")
    private Objectif objectif;

    /**
     * Les compétences du cv.
     */
    @Transient
    @XmlElement(name = "competences", namespace = "http://univ.fr/cv24", required = true)
    private Competence competences;

    /**
     * Les informations diverses du cv.
     */
    @Transient
    @XmlElement(name = "divers", namespace = "http://univ.fr/cv24", nillable = true)
    private Divers divers;

    // Getters et Setters pour les éléments

    /**
     * Retourne les informations d'identité du cv.
     *
     * @return Les informations d'identité.
     */
    public Identite getIdentite() {
        return identite;
    }

    /**
     * Modifie les informations d'identité du cv.
     *
     * @param identite Les nouvelles informations d'identité.
     */
    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    /**
     * Retourne l'objectif du cv.
     *
     * @return L'objectif.
     */
    public Objectif getObjectif() {
        return objectif;
    }

    /**
     * Modifie l'objectif professionnel du cv.
     *
     * @param objectif Le nouvel objectif.
     */
    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    /**
     * Retourne les expériences professionnelles du cv.
     *
     * @return Les expériences professionnelles.
     */
    public Prof getProf() {
        return prof;
    }

    /**
     * Modifie les informations professionnelles du cv.
     *
     * @param prof Les nouvelles expériences professionnelles.
     */
    public void setProf(Prof prof) {
        this.prof = prof;
    }

    /**
     * Retourne les compétences du cv.
     *
     * @return Les compétences.
     */
    public Competence getCompetences() {
        return competences;
    }

    /**
     * Modifie les compétences du cv.
     *
     * @param competences Les nouvelles compétences.
     */
    public void setCompetences(Competence competences) {
        this.competences = competences;
    }

    /**
     * Retourne les informations diverses du cv.
     *
     * @return Les informations diverses.
     */
    public Divers getDivers() {
        return divers;
    }

    /**
     * Modifie les informations diverses du cv.
     *
     * @param divers Les nouvelles informations diverses.
     */
    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    /**
     * Retourne l'identifiant unique du CV.
     *
     * @return L'identifiant unique.
     */
    public int getId() {
        return id;
    }

    /**
     * Modifie l'identifiant unique du CV.
     *
     * @param id Le nouvel identifiant unique.
     */
    public void setId(int id) {
        this.id = id;
    }
}
