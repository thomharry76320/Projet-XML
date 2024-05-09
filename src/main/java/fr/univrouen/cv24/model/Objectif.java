package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Objectif" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "objectif")
public class Objectif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    @Column(name = "obj", length = 128)
    @XmlElement(name="objectif")
    private String objectif;

    @Column(name = "statut")
    @XmlAttribute(name = "status")
    private String status;

    /**
     * Obtient l'identifiant de l'objectif.
     *
     * @return L'identifiant de l'objectif.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de l'objectif.
     *
     * @param id L'identifiant de l'objectif.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'objectif professionnel.
     *
     * @return L'objectif professionnel.
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * Définit l'objectif professionnel.
     *
     * @param objectif L'objectif professionnel.
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    /**
     * Obtient le statut de l'objectif.
     *
     * @return Le statut de l'objectif.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Définit le statut de l'objectif.
     *
     * @param status Le statut de l'objectif.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtient l'identifiant du CV auquel cet objectif est associé.
     *
     * @return L'identifiant du CV.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV auquel cet objectif est associé.
     *
     * @param cv L'identifiant du CV.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
