package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.services.CVService;
import fr.univrouen.cv24.xml.XMLMessageBuilder;
import fr.univrouen.cv24.xml.XMLTransform;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * Contrôleur pour gérer les requêtes POST liées à l'application.
 */
@Controller
public class postController {

    @Autowired
    private CVService cvservice;

    /**
     * Méthode POST pour insérer un CV à partir d'un fichier XML.
     *
     * @param xmlContent Le contenu XML envoyé dans la requête POST.
     * @return Une réponse HTTP avec un message XML indiquant le résultat de l'insertion.
     * @throws JAXBException Si une erreur survient lors de la transformation XML en objet CV24.
     * @throws IOException   Si une erreur d'entrée/sortie se produit.
     * @throws SAXException  Si une erreur se produit lors de l'analyse XML.
     */
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> addCV(@RequestBody String xmlContent) throws JAXBException, IOException, SAXException {
        XMLTransform transform = new XMLTransform();
        XMLMessageBuilder message = new XMLMessageBuilder();
        CV24 cv;
        cv = transform.ConvertXmlToCv(xmlContent);
        cv = cvservice.saveCV(cv);

        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(message.buildInsertMessage(cv.getId(), "INSERTED"));
    }
}