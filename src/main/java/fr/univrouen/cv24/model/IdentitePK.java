package fr.univrouen.cv24.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

/**
 * Cette classe représente une clé primaire composée pour l'entité Identite.
 */
@Embeddable
public class IdentitePK implements Serializable {

    private String nom; // Le nom de la personne
    private String prenom; // Le prénom de la personne

    /**
     * Constructeur par défaut de la classe IdentitePK.
     */
    public IdentitePK() {}

    /**
     * Obtient le nom de la personne.
     *
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la personne.
     *
     * @param nom Le nom de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de la personne.
     *
     * @return Le prénom de la personne.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de la personne.
     *
     * @param prenom Le prénom de la personne.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
