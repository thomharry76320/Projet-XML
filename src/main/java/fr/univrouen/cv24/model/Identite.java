package fr.univrouen.cv24.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "identite", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom", "prenom"})
})
@IdClass(IdentitePK.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite {

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    @Column(name = "genre", length = 128)
    @XmlElement(name = "genre")
    private String genre;

    @Id
    @Column(name = "nom", nullable = false)
    @XmlElement(name = "nom")
    private String nom;

    @Id
    @Column(name = "prenom", nullable = false)
    @XmlElement(name = "prenom")
    private String prenom;

    @Column(name = "tel")
    @XmlElement(name = "tel")
    private String tel;

    @Column(name = "email")
    @XmlElement(name = "mail")
    private String mel;

    // Getters et Setters

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMel() {
        return mel;
    }

    public void setMel(String mel) {
        this.mel = mel;
    }

    public int getcvID() {
        return cvId;
    }

    public void setcvID(int cv) {
        this.cvId = cv;
    }
}