package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.Serializable;

/**
 * Cette classe représente une entité "CVResume" dans le modèle CV.
 */
@XmlType(name = "cvResume")
@XmlAccessorType(XmlAccessType.FIELD)
public class CVResume implements Serializable {

    /**
     * L'identifiant du CV.
     */
    @XmlElement(name = "id", required = true)
    private int id;

    /**
     * Le genre du cv.
     */
    @XmlElement(name = "genre", required = true)
    private String genre;

    /**
     * Le nom du cv.
     */
    @XmlElement(name = "nom", required = true)
    private String nom;

    /**
     * Le prénom du cv.
     */
    @XmlElement(name = "prenom", required = true)
    private String prenom;

    /**
     * L'objectif professionnel du cv.
     */
    @XmlElement(name = "objectif", required = true)
    private String objectif;

    /**
     * La liste des diplômes du cv.
     */
    @XmlElement(name = "diplôme", required = true)
    private Diplome diplome;

    /**
     * Récupère le genre du cv.
     *
     * @return Le genre du cv.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Définit le genre du cv.
     *
     * @param genre Le genre du cv.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Récupère le nom du cv.
     *
     * @return Le nom du cv.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du cv.
     *
     * @param nom Le nom du cv.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Récupère le prénom du cv.
     *
     * @return Le prénom du cv.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom du cv.
     *
     * @param prenom Le prénom du cv.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Récupère l'objectif professionnel du cv.
     *
     * @return L'objectif professionnel du cv.
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * Définit l'objectif professionnel du cv.
     *
     * @param objectif L'objectif professionnel du cv.
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    /**
     * Récupère le diplome le plus important du cv.
     *
     * @return le diplome le plus important du cv.
     */
    public Diplome getDiplome() {
        return diplome;
    }

    /**
     * Définit le diplome le plus important du cv.
     *
     * @param diplome le diplome le plus important du cv.
     */
    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    /**
     * Récupère l'identifiant du CV.
     *
     * @return L'identifiant du CV.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du CV.
     *
     * @param id L'identifiant du CV.
     */
    public void setId(int id) {
        this.id = id;
    }
}
