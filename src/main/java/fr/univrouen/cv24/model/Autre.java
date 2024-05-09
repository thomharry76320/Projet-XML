package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Autre" dans le modèle CV.
 *
 */
@Entity
@Table(name ="autre")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autre")
public class Autre {

    /**
     * L'identifiant unique de l'entité "Autre".
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /**
     * L'identifiant du CV auquel cet élément "Autre" est associé.
     */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /**
     * Le titre de cet élément "Autre".
     */
    @Column(name = "titre", nullable = false)
    @XmlAttribute(name ="titre", required = true)
    private String titre;

    /**
     * Les commentaires supplémentaires sur cet élément "Autre".
     */
    @Column(name = "comment")
    @XmlAttribute(name ="comment")
    private String comment;

    /**
     * Obtient le titre de cet élément "Autre".
     *
     * @return Le titre de l'élément "Autre".
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre de cet élément "Autre".
     *
     * @param titre Le nouveau titre de l'élément "Autre".
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient le commentaire sur cet élément "Autre".
     *
     * @return Le commentaire sur l'élément "Autre".
     */
    public String getComment() {
        return comment;
    }

    /**
     * Définit le commentaire sur cet élément "Autre".
     *
     * @param comment Le nouveau commentaire sur l'élément "Autre".
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Obtient l'identifiant de cet élément "Autre".
     *
     * @return L'identifiant de l'élément "Autre".
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de cet élément "Autre".
     *
     * @param id Le nouvel identifiant de l'élément "Autre".
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'identifiant du CV auquel cet élément "Autre" est associé.
     *
     * @return L'identifiant du CV associé à l'élément "Autre".
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV auquel cet élément "Autre" est associé.
     *
     * @param cv L'identifiant du CV associé à l'élément "Autre".
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}