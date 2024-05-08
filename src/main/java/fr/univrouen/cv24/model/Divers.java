package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diversType", propOrder = {"lv", "autre"})
public class Divers {
    @XmlElement(name ="lv", required = true)
    private List<Langue> lv;

    @XmlElement(name ="autre")
    private List<Autre> autre;

    public List<Langue> getLv() {
        return lv;
    }

    public void setLv(List<Langue> lv) {
        this.lv = lv;
    }

    public List<Autre> getAutre() {
        return autre;
    }

    public void setAutre(List<Autre> autre) {
        this.autre = autre;
    }
}
