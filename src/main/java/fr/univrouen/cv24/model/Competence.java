package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.List;

/**
 * Cette classe représente une entité "Compétence" dans le modèle CV.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "competences", propOrder = {"diplome", "certif"})
public class Competence {

    /**
     * Liste des diplômes de l'individu.
     */
    @XmlElement(name ="diplôme", required = true)
    private List<Diplome> diplome;

    /**
     * Liste des certifications de l'individu.
     */
    @XmlElement(name ="certif")
    private List<Certification> certif;

    /**
     * Obtient la liste des diplômes.
     *
     * @return La liste des diplômes de l'individu.
     */
    public List<Diplome> getDiplome() {
        return diplome;
    }

    /**
     * Définit la liste des diplômes.
     *
     * @param diplome La liste des diplômes à définir.
     */
    public void setDiplome(List<Diplome> diplome) {
        this.diplome = diplome;
    }

    /**
     * Obtient la liste des certifications.
     *
     * @return La liste des certifications de l'individu.
     */
    public List<Certification> getCertif() {
        return certif;
    }

    /**
     * Définit la liste des certifications.
     *
     * @param certif La liste des certifications à définir.
     */
    public void setCertif(List<Certification> certif) {
        this.certif = certif;
    }
}
