package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

/**
 * Cette classe représente une entité "Langue" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lv")
@Entity
@Table(name ="langue")
public class Langue {

    /** Identifiant unique de la langue. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    /** Identifiant du CV auquel cette langue est associée. */
    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    /** Langue maîtrisée. */
    @Column(name = "lang", nullable = false)
    @XmlAttribute(name="lang", required = true)
    private String lang;

    /** Certificat attestant de la maîtrise de la langue. */
    @Column(name = "cert", nullable = false)
    @XmlAttribute(name ="cert", required = true)
    private String cert;

    /** Niveau de maîtrise à l'oral (optionnel). */
    @Column(name = "nivs")
    @XmlAttribute(name ="nivs")
    private String nivs;

    /** Niveau de maîtrise à l'écrit (optionnel). */
    @Column(name = "nivi")
    @XmlAttribute(name = "nivi")
    private Integer nivi;

    /**
     * Obtient le nom de la langue.
     * @return Le nom de la langue.
     */
    public String getLang() {
        return lang;
    }

    /**
     * Définit le nom de la langue.
     * @param lang Le nom de la langue.
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * Obtient le certificat attestant la maîtrise de la langue.
     * @return Le certificat.
     */
    public String getCert() {
        return cert;
    }

    /**
     * Définit le certificat attestant la maîtrise de la langue.
     * @param cert Le certificat.
     */
    public void setCert(String cert) {
        this.cert = cert;
    }

    /**
     * Obtient le niveau de maîtrise à l'oral.
     * @return Le niveau de maîtrise à l'oral.
     */
    public String getNivs() {
        return nivs;
    }

    /**
     * Définit le niveau de maîtrise à l'oral.
     * @param nivs Le niveau de maîtrise à l'oral.
     */
    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    /**
     * Obtient le niveau de maîtrise à l'écrit.
     * @return Le niveau de maîtrise à l'écrit.
     */
    public Integer getNivi() {
        return nivi;
    }

    /**
     * Définit le niveau de maîtrise à l'écrit.
     * @param nivi Le niveau de maîtrise à l'écrit.
     */
    public void setNivi(Integer nivi) {
        this.nivi = nivi;
    }

    /**
     * Obtient l'identifiant de la langue.
     * @return L'identifiant de la langue.
     */
    public int getId() {
        return id;
    }

    /**
     * Définit l'identifiant de la langue.
     * @param id L'identifiant de la langue.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtient l'identifiant du CV associé à cette langue.
     * @return L'identifiant du CV.
     */
    public int getcvID() {
        return cvId;
    }

    /**
     * Définit l'identifiant du CV associé à cette langue.
     * @param cv L'identifiant du CV.
     */
    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
