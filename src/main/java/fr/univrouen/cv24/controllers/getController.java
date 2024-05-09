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

/**
 * Contrôleur pour gérer les requêtes GET liées à l'application.
 */
@Controller
public class getController {

    @Autowired
    private CVService cvservice;

    /**
     * Affiche la page d'accueil.
     *
     * @return Retourne la page d'accueil au format HTML.
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * Affiche la page d'aide.
     *
     * @return Retourne la page d'aide au format HTML.
     */
    @GetMapping("/help")
    public String help() {
        return "help";
    }

    /**
     * Récupère les résumés des CV au format HTML.
     *
     * @param model Le modèle Spring pour transmettre les données à la vue.
     * @return Retourne les résumés des CV au format XML ou un message d'erreur au format XML.
     */
    @GetMapping("/cv24/resume")
    public String resume(Model model) {
        List<CV24> l =  cvservice.getResumeCV();
        model.addAttribute("cvs", l);
        return "resume";
    }

    /**
     * Récupère les résumés des CV au format XML.
     *
     * @return  Retourne  les résumés des CV au format XML ou un message d'erreur au format XML
     * @throws JAXBException Si une erreur survient lors de la génération du XML.
     */
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

    /**
     * Récupère un CV complet au format XML par son ID.
     *
     * @param cvId L'identifiant du CV.
     * @return Retourne le CV complet au format XML ou un message d'erreur au format XML.
     * @throws JAXBException Si une erreur survient lors de la génération du XML.
     */
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

    /**
     * Récupère un CV complet au format HTML par son ID.
     *
     * @param cvId L'identifiant du CV.
     * @param model Le modèle Spring pour transmettre les données à la vue.
     * @return Retourne le CV au format XML ou un message d'erreur au format XML.
     */
    @GetMapping("/cv24/html")
    public String getCVCompletHTMLByID(@RequestParam("id") int cvId, Model model){
        CV24 cv = cvservice.getCVById(cvId);
        model.addAttribute("cv", cv);
        return "cv";
    }
}