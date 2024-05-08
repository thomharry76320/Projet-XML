package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

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

    // Getters et Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getcvID() {
        return cvId;
    }

    public void setcvID(int cv) {
        this.cvId = cv;
    }
}