package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prof")
public class Prof {

    @XmlElement(name ="detail", required = true)
    private List<Detail> details;

    public List<Detail> getDetail() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

}