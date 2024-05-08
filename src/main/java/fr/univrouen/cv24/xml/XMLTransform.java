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

public class XMLTransform {

    public XMLTransform() {}

    // Convertie un CV au format XML en un CV24.
    public CV24 ConvertXmlToCv(String xmlContent) throws JAXBException, IOException, SAXException {
        XMLValidator.validateXMLAgainstXSD(xmlContent, "cv24.xsd");
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(xmlContent);
        // Désérialisez le XML en un objet Java
        return (CV24) unmarshaller.unmarshal(reader);
    }

    // Convertie un CV24 en son format XML correspondant.
    public String convertCVtoXML(CV24 cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CV24.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        // Remplacez les occurrences de ns2: par cv24 (par trouver d'autre solution)
        String message  = writer.toString().replaceAll("ns2", "cv24");
        // Pour régler le problème des objets vides.
        message = message.replaceAll("<cv24:prof/>", "");
        message = message.replaceAll("<cv24:divers/>", "");
        return message;
    }

    // Permet de transformer une liste de CV résumer en XML
    public String convertCVResumeToXML(ListCVResume cv) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListCVResume.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter writer = new StringWriter();
        marshaller.marshal(cv, writer);
        return writer.toString();
    }

}
