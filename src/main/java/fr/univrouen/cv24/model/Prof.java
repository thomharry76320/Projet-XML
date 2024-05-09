package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

/**
 * Cette classe représente une entité "Prof" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prof")
public class Prof {

    @XmlElement(name ="detail", required = true)
    private List<Detail> details;

    /**
     * Obtient les détails du prof.
     *
     * @return La liste des détails du prof.
     */
    public List<Detail> getDetail() {
        return details;
    }

    /**
     * Définit les détails du prof.
     *
     * @param details La liste des détails du prof à définir.
     */
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

}
