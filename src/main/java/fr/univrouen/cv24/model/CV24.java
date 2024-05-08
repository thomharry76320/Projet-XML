package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.io.Serializable;

@Entity
@XmlRootElement(name = "cv24", namespace = "http://univ.fr/cv24")
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "cv")
public class CV24 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Transient
    @XmlElement(name = "identite", namespace = "http://univ.fr/cv24", required = true)
    private Identite identite;

    @Transient
    @XmlElement(name = "prof", namespace = "http://univ.fr/cv24", nillable = true)
    private Prof prof;

    @Transient
    @XmlElement(name = "objectif", namespace = "http://univ.fr/cv24")
    private Objectif objectif;

    @Transient
    @XmlElement(name = "competences", namespace = "http://univ.fr/cv24", required = true)
    private Competence competences;

    @Transient
    @XmlElement(name = "divers", namespace = "http://univ.fr/cv24", nillable = true)
    private Divers divers;

    // Getters et Setters pour les éléments

    public Identite getIdentite() {
        return identite;
    }

    public void setIdentite(Identite identite) {
        this.identite = identite;
    }

    public Objectif getObjectif() {
        return objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Competence getCompetences() {
        return competences;
    }

    public void setCompetences(Competence competences) {
        this.competences = competences;
    }

    public Divers getDivers() {
        return divers;
    }

    public void setDivers(Divers divers) {
        this.divers = divers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



