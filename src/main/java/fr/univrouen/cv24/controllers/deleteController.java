package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.services.CVService;
import fr.univrouen.cv24.xml.XMLMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Cette classe gère les requêtes de suppression de CV.
 * Elle permet de supprimer un CV en utilisant une requête DELETE HTTP.
 */
@Controller
public class deleteController {

    @Autowired
    private CVService cvservice;

    /**
     * Méthode pour supprimer un CV spécifié par son identifiant.
     *
     * @param cvId L'identifiant du CV à supprimer.
     * @return Retourne un XML contenant un message de confirmation ou un message d'erreur en cas d'échec.
     */
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> deleteCV(@RequestParam("id") int cvId) {
        // Supprimer le CV avec l'ID spécifié
        boolean deleted = cvservice.deleteCV(cvId);
        XMLMessageBuilder message = new XMLMessageBuilder();

        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(message.buildDeleteMessage(cvId, "DELETED"));
    }
}