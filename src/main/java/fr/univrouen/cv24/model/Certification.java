package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Certification" dans le modèle CV.
 */
@Entity
@Table(name ="certification")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certifType", propOrder = {"datedeb", "datefin", "titre"})
public class Certification {

    /** Identifiant de la certification. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /** Identifiant du CV auquel cette certification est associée. */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /** Date de début de la certification. */
    @Column(name = "datedeb", nullable = false)
    @XmlElement(name ="datedeb", required = true)
    private String datedeb;

    /** Date de fin de la certification. */
    @Column(name = "datefin")
    @XmlElement(name ="datefin")
    private String datefin;

    /** Titre de la certification. */
    @Column(name = "titre", length = 32)
    @XmlElement(name ="titre", required = true)
    private String titre;

    /**
     * Obtient la date de début de la certification.
     *
     * @return La date de début de la certification.
     */
    public String getDatedeb() {
        return datedeb;
    }

    /**
     * Définit la date de début de la certification.
     *
     * @param datedeb La nouvelle date de début de la certification.
     */
    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    /**
     * Obtient la date de fin de la certification.
     *
     * @return La date de fin de la certification.
     */
    public String getDatefin() {
        return datefin;
    }

    /**
     * Définit la date de fin de la certification.
     *
     * @param datefin La nouvelle date de fin de la certification.
     */
    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    /**
     * Obtient le titre de la certification.
     *
     * @return Le titre de la certification.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre de la certification.
     *
     * @param titre Le nouveau titre de la certification.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient l'identifiant de la certification.
     *
     * @return L'identifiant de la certification.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la certification.
     *
     * @param id Le nouvel identifiant de la certification.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'identifiant du CV auquel cette certification est associée.
     *
     * @return L'identifiant du CV.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV auquel cette certification est associée.
     *
     * @param cv L'identifiant du CV.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }

}
