package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import java.util.List;

/**
 * Cette classe représente une entité "Diplome" dans le modèle CV.
 */
@Entity
@Table(name ="diplome")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplôme", propOrder = {"date", "institut", "titre"})
public class Diplome {

    /**
     * L'identifiant unique du diplôme.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /**
     * L'identifiant du CV auquel ce diplôme est associé.
     */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /**
     * La date d'obtention du diplôme.
     */
    @Column(name = "date", nullable = false)
    @XmlElement(name ="date", required = true)
    private String date;

    /**
     * L'institut délivrant le diplôme.
     */
    @Column(name = "institut", length = 32)
    @XmlElement(name ="institut")
    private String institut;

    /**
     * Les titres ou mentions associés au diplôme.
     */
    @Transient
    @XmlElement(name ="titre", required = true)
    private List<Titre> titre;

    /**
     * Le niveau du diplôme.
     */
    @Column(name = "niveau")
    @XmlAttribute(name ="niveau", required = true)
    private int niveau;

    /**
     * Obtient la date d'obtention du diplôme.
     *
     * @return La date d'obtention du diplôme.
     */
    public String getDate() {
        return date;
    }

    /**
     * Définit la date d'obtention du diplôme.
     *
     * @param date La date d'obtention du diplôme.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Obtient l'institut délivrant le diplôme.
     *
     * @return L'institut délivrant le diplôme.
     */
    public String getInstitut() {
        return institut;
    }

    /**
     * Définit l'institut ou l'école délivrant le diplôme.
     *
     * @param institut L'institut ou l'école délivrant le diplôme.
     */
    public void setInstitut(String institut) {
        this.institut = institut;
    }

    /**
     * Obtient les titres ou mentions associés au diplôme.
     *
     * @return Les titres ou mentions associés au diplôme.
     */
    public List<Titre> getTitre() {
        return titre;
    }

    /**
     * Définit les titres ou mentions associés au diplôme.
     *
     * @param titre Les titres ou mentions associés au diplôme.
     */
    public void setTitre(List<Titre> titre) {
        this.titre = titre;
    }

    /**
     * Obtient le niveau du diplôme.
     *
     * @return Le niveau du diplôme.
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Définit le niveau du diplôme.
     *
     * @param niveau Le niveau du diplôme.
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * Obtient l'identifiant unique du diplôme.
     *
     * @return L'identifiant unique du diplôme.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant unique du diplôme.
     *
     * @param id L'identifiant unique du diplôme.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'identifiant du CV auquel ce diplôme est associé.
     *
     * @return L'identifiant du CV auquel ce diplôme est associé.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV auquel ce diplôme est associé.
     *
     * @param cv L'identifiant du CV auquel ce diplôme est associé.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
