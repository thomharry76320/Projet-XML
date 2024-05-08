package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competences", propOrder = {"diplome", "certif"})
public class Competence {

    @XmlElement(name ="diplôme", required = true)
    private List<Diplome> diplome;

    @XmlElement(name ="certif")
    private List<Certification> certif;

    public List<Diplome> getDiplome() {
        return diplome;
    }

    public void setDiplome(List<Diplome> diplome) {
        this.diplome = diplome;
    }

    public List<Certification> getCertif() {
        return certif;
    }

    public void setCertif(List<Certification> certif) {
        this.certif = certif;
    }
}
