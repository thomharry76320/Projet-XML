package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Detail" dans le modèle CV.
 */
@Entity
@Table(name ="detail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detailType", propOrder = {"datedeb", "datefin", "titre"})
public class Detail {

    /**
     * L'identifiant unique du détail.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /**
     * L'identifiant du CV auquel ce détail est associé.
     */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /**
     * La date de début du détail.
     */
    @Column(name = "datedeb", nullable = false)
    @XmlElement(name ="datedeb", required = true)
    private String datedeb;

    /**
     * La date de fin du détail.
     */
    @Column(name = "datefin")
    @XmlElement(name ="datefin")
    private String datefin;

    /**
     * Le titre du détail.
     */
    @Column(name = "titre", length = 32)
    @XmlElement(name ="titre", required = true)
    private String titre;

    /**
     * Obtient la date de début du détail.
     *
     * @return La date de début du détail.
     */
    public String getDatedeb() {
        return datedeb;
    }

    /**
     * Définit la date de début du détail.
     *
     * @param datedeb La nouvelle date de début du détail.
     */
    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    /**
     * Obtient la date de fin du détail.
     *
     * @return La date de fin du détail.
     */
    public String getDatefin() {
        return datefin;
    }

    /**
     * Définit la date de fin du détail.
     *
     * @param datefin La nouvelle date de fin du détail.
     */
    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    /**
     * Obtient le titre du détail.
     *
     * @return Le titre du détail.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre du détail.
     *
     * @param titre Le nouveau titre du détail.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient l'identifiant du détail.
     *
     * @return L'identifiant du détail.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant du détail.
     *
     * @param id Le nouvel identifiant du détail.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'identifiant du CV associé à ce détail.
     *
     * @return L'identifiant du CV associé à ce détail.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV associé à ce détail.
     *
     * @param cv L'identifiant du CV associé à ce détail.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}