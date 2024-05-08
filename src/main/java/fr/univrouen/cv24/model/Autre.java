package fr.univrouen.cv24.model;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

@Entity
@Table(name ="autre")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autre")
public class Autre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private int id;

    @Column(name = "cv_id", nullable = false)
    @XmlTransient
    private int cvId;

    @Column(name = "titre", nullable = false)
    @XmlAttribute(name ="titre", required = true)
    private String titre;

    @Column(name = "comment")
    @XmlAttribute(name ="comment")
    private String comment;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
