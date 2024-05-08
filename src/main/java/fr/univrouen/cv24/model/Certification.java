package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name ="certification")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certifType", propOrder = {"datedeb", "datefin", "titre"})
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    @Column(name = "datedeb", nullable = false)
    @XmlElement(name ="datedeb", required = true)
    private String datedeb;
    @Column(name = "datefin")
    @XmlElement(name ="datefin")
    private String datefin;

    @Column(name = "titre", length = 32)
    @XmlElement(name ="titre", required = true)
    private String titre;

    public String getDatedeb() {
        return datedeb;
    }

    public void setDatedeb(String datedeb) {
        this.datedeb = datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public void setDatefin(String datefin) {
        this.datefin = datefin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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
