package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.services.*;
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

@Controller
public class postController {

    @Autowired
    private CVService cvservice;


    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> addIdentite(@RequestBody String xmlContent) throws JAXBException, IOException, SAXException {
        XMLTransform transform = new XMLTransform();
        CV24 cv;
        cv = transform.ConvertXmlToCv(xmlContent);
        cv = cvservice.saveCV(cv);
        String xmlResponse = "<message>" +
                "   <id>" + cv.getId() + "</id>\n" +
                "   <status>INSERTED</status>\n" +
                "</message>";

        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(xmlResponse);
    }
}