package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "titre")
@Entity
@Table(name = "titre")
public class Titre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "titre", nullable = false)
    @XmlValue
    private String titre;

    @Column(name = "diplome_id", nullable = false)
    @XmlTransient
    private int diplomeid;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDiplomeID() {
        return diplomeid;
    }

    public void setDiplomeID(int id) {
        this.diplomeid = id;
    }
}