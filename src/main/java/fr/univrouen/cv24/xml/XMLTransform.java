package fr.univrouen.cv24.xml;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.ListCVResume;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Cette classe fournit des méthodes pour transformer des objets Java en XML et vice versa.
 */
public class XMLTransform {

    /**
     * Constructeur par défaut de la classe XMLTransform.
     */
    public XMLTransform() {}

    /**
     * Convertit un contenu XML représentant un CV en un objet CV24.
     *
     * @param xmlContent Le contenu XML représentant le CV.
     * @return Un objet CV24 représentant le CV.
     * @throws JAXBException Si une erreur survient lors de la désérialisation XML.
     * @throws IOException Si une erreur d'entrée/sortie survient lors de la validation XML.
     * @throws SAXException Si une erreur SAX survient lors de la validation XML.
     */
    public CV24 ConvertXmlToCv(String xmlContent) throws JAXBException, IOException, SAXException {
        // Valider le XML contre le schéma XSD
        XMLValidator.validateXMLAgainstXSD(xmlContent, "cv24.xsd");
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlContent);
        // Désérialiser le XML en un objet Java
        return (CV24) unmarshaller.unmarshal(reader);
    }

    /**
     * Convertit un objet CV24 en son représentation XML correspondante.
     *
     * @param cv L'objet CV24 à convertir en XML.
     * @return La représentation XML de l'objet CV24.
     * @throws JAXBException Si une erreur survient lors de la sérialisation XML.
     */
    public String convertCVtoXML(CV24 cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        // Remplacer les occurrences de ns2: par cv24 (à trouver une autre solution)
        String message  = writer.toString().replaceAll("ns2", "cv24");
        // Résoudre le problème des objets vides.
        message = message.replaceAll("<cv24:prof/>", "");
        message = message.replaceAll("<cv24:divers/>", "");
        return message;
    }

    /**
     * Transforme une liste de CV résumé en XML.
     *
     * @param cv La liste de CV résumé à convertir en XML.
     * @return La représentation XML de la liste de CV résumé.
     * @throws JAXBException Si une erreur survient lors de la sérialisation XML.
     */
    public String convertCVResumeToXML(ListCVResume cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListCVResume.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        return writer.toString();
    }
}
