package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class deleteController {

    @Autowired
    private CVService cvservice;

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> deleteCV(@RequestParam("id") int cvId) {
        // Supprimer le CV avec l'ID spécifié
        boolean deleted = cvservice.deleteCV(cvId);
        String xmlResponse = "<message>" +
                "   <id>" + cvId + "</id>\n" +
                "   <status>DELETED</status>\n" +
                "</message>";
        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(xmlResponse);
    }
}
