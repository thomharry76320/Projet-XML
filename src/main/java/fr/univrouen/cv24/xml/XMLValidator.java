package fr.univrouen.cv24.xml;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;

@Component
public class XMLValidator {

    // Vérifie si un fichier XML est valide par rapport au fichier XSD passé en paramétre
    public static boolean validateXMLAgainstXSD(String xmlContent, String xsdFilePath) throws IOException, SAXException {
            ClassPathResource resourceXSD = new ClassPathResource(xsdFilePath);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource(resourceXSD.getFile());
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            StringReader reader = new StringReader(xmlContent);
            Source source = new StreamSource(reader);

            // Validez la source XML par rapport au schéma XSD
            validator.validate(source);
            return true;
    }
}