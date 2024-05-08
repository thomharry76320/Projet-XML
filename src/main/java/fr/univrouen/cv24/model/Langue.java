package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lv")
@Entity
@Table(name ="langue")
public class Langue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;
    @Column(name = "lang", nullable = false)
    @XmlAttribute(name="lang", required = true)
    private String lang;

    @Column(name = "cert", nullable = false)
    @XmlAttribute(name ="cert", required = true)
    private String cert;

    @Column(name = "nivs")
    @XmlAttribute(name ="nivs")
    private String nivs;

    @Column(name = "nivi")
    @XmlAttribute(name = "nivi")
    private Integer nivi;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getNivs() {
        return nivs;
    }

    public void setNivs(String nivs) {
        this.nivs = nivs;
    }

    public Integer getNivi() {
        return nivi;
    }

    public void setNivi(Integer nivi) {
        this.nivi = nivi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcvID() {
        return cvId;
    }

    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
