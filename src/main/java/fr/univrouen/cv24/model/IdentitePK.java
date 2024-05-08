package fr.univrouen.cv24.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IdentitePK implements Serializable {
    private String nom;
    private String prenom;

    // Constructeur par défaut
    public IdentitePK() {}

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
}
