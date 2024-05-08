package fr.univrouen.cv24.model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@Table(name ="diplome")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplôme", propOrder = {"date", "institut", "titre"})
public class Diplome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    @Column(name = "date", nullable = false)
    @XmlElement(name ="date", required = true)
    private String date;

    @Column(name = "institut", length = 32)
    @XmlElement(name ="institut")
    private String institut;

    @Transient
    @XmlElement(name ="titre", required = true)
    private List<Titre> titre;

    @Column(name = "niveau")
    @XmlAttribute(name ="niveau", required = true)
    private int niveau;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstitut() {
        return institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }

    public List<Titre> getTitre() {
        return titre;
    }

    public void setTitre(List<Titre> titre) {
        this.titre = titre;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    public int getcvID() {
        return cvId;
    }

    public void setcvID(int cv) {
        this.cvId = cv;
    }
}
