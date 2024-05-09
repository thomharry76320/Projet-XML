package fr.univrouen.cv24.xml;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.CVResume;
import fr.univrouen.cv24.model.ListCVResume;
import jakarta.xml.bind.JAXBException;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe fournit des méthodes pour construire des messages XML utilisés dans le cadre
 * de la manipulation des CV.
 */
public class XMLMessageBuilder {

    /**
     * Construit le message d'une erreur obtenue avec le statut qui définit le type d'erreur
     * et le détail qui est un résumé de l'erreur.
     *
     * @param statut Le statut de l'erreur.
     * @param detail Le détail de l'erreur.
     * @return Le message d'erreur au format XML.
     */
    public String buildErrorMessage(String statut, String detail) {
        String message = "<message>" +
                "   <status>" + statut + "</status>\n" +
                "   <detail>" + detail + "</detail>\n" +
                "</message>";
        return message;
    }

    /**
     * Construit le message de retour pour l'opération insert avec comme paramètre l'id du CV inséré
     * et le statut de la requête.
     *
     * @param id     L'identifiant du CV inséré.
     * @param statut Le statut de la requête.
     * @return Le message de retour pour l'insertion au format XML.
     */
    public String buildInsertMessage(int id, String statut) {
        String message = "<message>" +
                "   <id>" + id + "</id>\n" +
                "   <status>" + statut + "</status>\n" +
                "</message>";
        return message;
    }

    /**
     * Construit le message de retour pour l'opération delete avec comme paramètre l'id du CV supprimé
     * et le statut de la requête.
     *
     * @param id     L'identifiant du CV supprimé.
     * @param statut Le statut de la requête.
     * @return Le message de retour pour la suppression au format XML.
     */
    public String buildDeleteMessage(int id, String statut) {
        String message = "<message>" +
                "   <id>" + id + "</id>\n" +
                "   <statut>" + statut + "</statut>\n" +
                "</message>";
        return message;
    }

    /**
     * Crée la réponse XML de la liste des CV résumés à partir de la liste des CV complets.
     *
     * @param listcv La liste des CV complets.
     * @return La réponse XML représentant la liste des CV résumés.
     * @throws JAXBException Si une erreur se produit lors de la transformation des données en XML.
     */
    public String buildListCvResume(List<CV24> listcv) throws JAXBException {
        ListCVResume resultat = new ListCVResume();
        List<CVResume> liste = new ArrayList<>();
        // Crée le résultat de chaque CV
        for (CV24 cv : listcv) {
            CVResume c = new CVResume();
            c.setDiplome(cv.getCompetences().getDiplome());
            c.setId(cv.getId());
            c.setObjectif(cv.getObjectif().getStatus() + " : " + cv.getObjectif().getObjectif());
            c.setNom(cv.getIdentite().getNom());
            c.setGenre(cv.getIdentite().getGenre());
            c.setPrenom(cv.getIdentite().getPrenom());
            liste.add(c);
        }
        resultat.setCvResumeList(liste);
        // Transforme au format XML la liste des CV résumés.
        XMLTransform t = new XMLTransform();
        return t.convertCVResumeToXML(resultat);
    }

}
