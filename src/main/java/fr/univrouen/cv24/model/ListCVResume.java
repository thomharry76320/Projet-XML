package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

/**
 * Cette classe représente un modèle XML pour la liste des résumés de CV.
 */
@XmlRootElement(name = "listcv")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCVResume implements Serializable {

    /**
     * La liste des résumés de CV.
     */
    @XmlElement(name = "cvResume")
    private List<CVResume> cvResumeList;

    /**
     * Récupère la liste des résumés de CV.
     *
     * @return La liste des résumés de CV.
     */
    public List<CVResume> getCvResumeList() {
        return cvResumeList;
    }

    /**
     * Définit la liste des résumés de CV.
     *
     * @param cv La liste des résumés de CV à définir.
     */
    public void setCvResumeList(List<CVResume> cv) {
        this.cvResumeList = cv;
    }
}

