package fr.univrouen.cv24.xml;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.CVResume;
import fr.univrouen.cv24.model.ListCVResume;
import jakarta.xml.bind.JAXBException;

import java.util.ArrayList;
import java.util.List;

public class XMLMessageBuilder {

    // Construit le message d'une erreur obtenue avec le status qui définit le type d'erreur et le détail qui est un résumé de l'erreur.
    public String buildErrorMessage(String statut, String detail) {
        String message = "<message>" +
                "   <status>" + statut + "</status>\n" +
                "   <detail>" + detail + "</detail>\n" +
                "</message>";
        return message;
    }

    // Construit le message de retour pour l'opération insert avec comme paramètre l'id du cv inséré et le statut de la requete.
    public String buildInsertMessage(int id, String statut){
        String message = "<message>" +
                "   <id>" + id + "</id>\n" +
                "   <status>" + statut + "</status>\n" +
                "</message>";
        return message;
    }

    // Construit le message de retour pour l'opération delete avec comme paramètre l'id du cv supprimé et le statut de la requete.
    public String buildDeleteMessage(int id, String statut) {
        String message = "<message>" +
                "   <id>"+ id + "</id>\n" +
                "   <statut>" + statut + "</statut>\n" +
                "</message>";
        return message;
    }

    // Créer la reponse XML de la liste des CV résumés à partir de la liste des CV complets.
    public String buildListCvResume(List<CV24> listcv) throws JAXBException {
        ListCVResume resultat = new ListCVResume();
        List<CVResume> liste  = new ArrayList<>();
        // Créer le résuler de chaque CV
        for (CV24 cv : listcv) {
            CVResume c = new CVResume();
            c.setDiplome(cv.getCompetences().getDiplome());
            c.setId(cv.getId());
            c.setObjectif(cv.getObjectif().getStatus() +" : " + cv.getObjectif().getObjectif());
            c.setNom(cv.getIdentite().getNom());
            c.setGenre(cv.getIdentite().getGenre());
            c.setPrenom(cv.getIdentite().getPrenom());
            liste.add(c);
        }
        resultat.setCvResumeList(liste);
        // Tansforme au foramt XML la liste des CV résumés.
        XMLTransform t = new XMLTransform();
        return t.convertCVResumeToXML(resultat);
    }

}
