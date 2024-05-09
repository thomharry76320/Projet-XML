package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
/**
 * Cette classe représente une entité "Identite" dans le modèle CV.
 */
@Entity
@Table(name = "identite", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom", "prenom"})
})
@IdClass(IdentitePK.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite {

    /**
     * L'ID du CV auquel cette identité est associée.
     */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /**
     * Le genre de la personne.
     */
    @Column(name = "genre", length = 128)
    @XmlElement(name = "genre")
    private String genre;

    /**
     * Le nom de la personne.
     */
    @Id
    @Column(name = "nom", nullable = false)
    @XmlElement(name = "nom")
    private String nom;

    /**
     * Le prénom de la personne.
     */
    @Id
    @Column(name = "prenom", nullable = false)
    @XmlElement(name = "prenom")
    private String prenom;

    /**
     * Le numéro de téléphone de la personne.
     */
    @Column(name = "tel")
    @XmlElement(name = "tel")
    private String tel;

    /**
     * L'adresse e-mail de la personne.
     */
    @Column(name = "email")
    @XmlElement(name = "mail")
    private String mel;

    // Getters et Setters

    /**
     * Obtient le genre de la personne.
     * @return Le genre de la personne.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit le genre de la personne.
     * @param genre Le genre de la personne.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Obtient le nom de la personne.
     * @return Le nom de la personne.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la personne.
     * @param nom Le nom de la personne.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de la personne.
     * @return Le prénom de la personne.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de la personne.
     * @param prenom Le prénom de la personne.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient le numéro de téléphone de la personne.
     * @return Le numéro de téléphone de la personne.
     */
    public String getTel() {
        return tel;
    }

    /**
     * Définit le numéro de téléphone de la personne.
     * @param tel Le numéro de téléphone de la personne.
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Obtient l'adresse e-mail de la personne.
     * @return L'adresse e-mail de la personne.
     */
    public String getMel() {
        return mel;
    }

    /**
     * Définit l'adresse e-mail de la personne.
     * @param mel L'adresse e-mail de la personne.
     */
    public void setMel(String mel) {
        this.mel = mel;
    }

    /**
     * Obtient l'ID du CV associé à cette identité.
     * @return L'ID du CV.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'ID du CV associé à cette identité.
     * @param cv L'ID du CV.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
