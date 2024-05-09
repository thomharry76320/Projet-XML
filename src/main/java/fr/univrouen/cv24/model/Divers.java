package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

/**
 * Cette classe représente une entité "Divers" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diversType", propOrder = {"lv", "autre"})
public class Divers {

    /**
     * Liste des langues maîtrisées par le candidat.
     */
    @XmlElement(name ="lv", required = true)
    private List<Langue> lv;

    /**
     * Liste d'autres informations diverses.
     */
    @XmlElement(name ="autre")
    private List<Autre> autre;

    /**
     * Obtient la liste des langues maîtrisées.
     *
     * @return La liste des langues maîtrisées.
     */
    public List<Langue> getLv() {
        return lv;
    }

    /**
     * Définit la liste des langues maîtrisées.
     *
     * @param lv La liste des langues maîtrisées à définir.
     */
    public void setLv(List<Langue> lv) {
        this.lv = lv;
    }

    /**
     * Obtient la liste d'autres informations diverses.
     *
     * @return La liste d'autres informations diverses.
     */
    public List<Autre> getAutre() {
        return autre;
    }

    /**
     * Définit la liste d'autres informations diverses.
     *
     * @param autre La liste d'autres informations diverses à définir.
     */
    public void setAutre(List<Autre> autre) {
        this.autre = autre;
    }
}
