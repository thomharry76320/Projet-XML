package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

// Correspond au model XML pour la liste des cv résumés.
@XmlRootElement(name = "listcv")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCVResume implements Serializable {

    @XmlElement(name = "cvResume")
    private List<CVResume> cvResumeList;

    public List<CVResume> getCvResumeList() {
        return cvResumeList;
    }

    public void setCvResumeList(List<CVResume> cv) {
        this.cvResumeList = cv;
    }
}
