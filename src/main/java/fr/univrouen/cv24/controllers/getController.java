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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class getController {

    @Autowired
    private CVService cvservice;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/help")
    public String help() {
        return "help";
    }

    @GetMapping("/cv24/resume")
    public String resume(Model model) {
        List<CV24> l =  cvservice.getResumeCV();
        model.addAttribute("cvs", l);
        return "resume";
    }

    @GetMapping(value ="/cv24/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> cvResumeXML() throws JAXBException {
        XMLMessageBuilder m = new XMLMessageBuilder();
        List<CV24> l =  cvservice.getResumeCV();
        String res = m.buildListCvResume(l);

        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(res);
    }

    @GetMapping(value ="/cv24/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getCVCompletXMLByID(@RequestParam("id") int cvId)  throws JAXBException {
        CV24 cv = cvservice.getCVById(cvId);
        XMLTransform transform = new XMLTransform();
        String cvXML = transform.convertCVtoXML(cv);
        // Retourner la réponse avec le code HTTP 200 (OK)
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_XML)
                .body(cvXML);
    }

    @GetMapping("/cv24/html")
    public String getCVCompletHTMLByID(@RequestParam("id") int cvId, Model model){
        CV24 cv = cvservice.getCVById(cvId);
        model.addAttribute("cv", cv);
        return "cv";
    }
}
