package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;
import java.util.List;

// Correspond au model XML pour le résumé d'un CV.
@XmlType(name = "cvResume")
@XmlAccessorType(XmlAccessType.FIELD)
public class CVResume implements Serializable {

    @XmlElement(name = "id", required = true)
    private int id;

    @XmlElement(name = "genre", required = true)
    private String genre;
    @XmlElement(name = "nom", required = true)
    private String nom;

    @XmlElement(name = "prenom", required = true)
    private String prenom;

    @XmlElement(name = "objectif", required = true)
    private String objectif;


    @XmlElement(name = "diplôme", required = true)
    private List<Diplome> diplome;



    // Getters et Setters pour les éléments

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public List<Diplome> getDiplome() {
        return diplome;
    }

    public void setDiplome(List<Diplome> diplome) {
        this.diplome = diplome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}