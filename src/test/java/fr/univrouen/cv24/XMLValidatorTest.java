package fr.univrouen.cv24;

import fr.univrouen.cv24.xml.XMLValidator;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class XMLValidatorTest {

    @Test
    public void shouldValidateXmlWithAnXsdFileWithValidXml() throws IOException, SAXException {
        // GIVEN
        String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.xsd \">\n" +
                "    <cv24:identite>\n" +
                "        <genre>Mr</genre>\n" +
                "        <nom>OLIVIER</nom>\n" +
                "        <prenom>THOMAS</prenom>\n" +
                "        <tel>+33 1 23 45 67 89</tel>\n" +
                "        <mail>thomas@gmail.com</mail>\n" +
                "    </cv24:identite>\n" +
                "    <cv24:objectif status=\"stage\">\n" +
                "        <objectif>AAAadjajoiqjfia1141412389.,':;@~$#()&amp;?!$*-_=</objectif>\n" +
                "    </cv24:objectif>\n" +
                "    <cv24:competences>\n" +
                "        <diplôme niveau=\"5\">\n" +
                "            <date>2024-04-11</date>\n" +
                "            <institut>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</institut>\n" +
                "            <titre>bac</titre>\n" +
                "        </diplôme>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <titre>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</titre>\n" +
                "        </certif>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <datefin>2024-04-11</datefin>\n" +
                "            <titre>afu</titre>\n" +
                "        </certif>\n" +
                "    </cv24:competences>\n" +
                "    <cv24:divers>\n" +
                "        <lv lang=\"fr\" cert=\"CLES\" nivs=\"B1\"/>\n" +
                "        <autre titre=\"sportif de haut niveau\" comment=\"natation\"></autre>\n" +
                "    </cv24:divers>\n" +
                "</cv24:cv24>";
        String xsdFile = "cv24.xsd";
        boolean result;
        // WHEN
        result = XMLValidator.validateXMLAgainstXSD(xmlFile,xsdFile);
        // THEN
        assertTrue(result);
    }

    @Test
    public void shouldThrowsIOExceptionWhenValidateXmlFile() {
        // GIVEN
        String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.xsd \">\n" +
                "    <cv24:identite>\n" +
                "        <genre>Mr</genre>\n" +
                "        <nom>OLIVIER</nom>\n" +
                "        <prenom>THOMAS</prenom>\n" +
                "        <tel>+33 1 23 45 67 89</tel>\n" +
                "        <mail>thomas@gmail.com</mail>\n" +
                "    </cv24:identite>\n" +
                "    <cv24:objectif status=\"stage\">\n" +
                "        <objectif>AAAadjajoiqjfia1141412389.,':;@~$#()&amp;?!$*-_=</objectif>\n" +
                "    </cv24:objectif>\n" +
                "    <cv24:competences>\n" +
                "        <diplôme niveau=\"5\">\n" +
                "            <date>2024-04-11</date>\n" +
                "            <institut>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</institut>\n" +
                "            <titre>bac</titre>\n" +
                "        </diplôme>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <titre>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</titre>\n" +
                "        </certif>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <datefin>2024-04-11</datefin>\n" +
                "            <titre>afu</titre>\n" +
                "        </certif>\n" +
                "    </cv24:competences>\n" +
                "    <cv24:divers>\n" +
                "        <lv lang=\"fr\" cert=\"CLES\" nivs=\"B1\"/>\n" +
                "        <autre titre=\"sportif de haut niveau\" comment=\"natation\"></autre>\n" +
                "    </cv24:divers>\n" +
                "</cv24:cv24>";
        String xsdFile = "fichierinconnue.xsd";
        // WHEN & THEN
        assertThrows(IOException.class, () -> {
            XMLValidator.validateXMLAgainstXSD(xmlFile,xsdFile);
        });
    }

    @Test
    public void shouldThrowsSAXExceptionWhenValidateXmlFile() throws IOException, SAXException {
        // GIVEN
        String xmlFile = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<cv24:cv24 xmlns:cv24=\"http://univ.fr/cv24\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://univ.fr/cv24 cv24.xsd \">\n" +
                "    <cv24:identite>\n" +
                "        <genre>Mr</genre>\n" +
                "        <nom>OLIVIER</nom>\n" +
                "        <tel>+33 1 23 45 67 89</tel>\n" +
                "        <mail>thomas@gmail.com</mail>\n" +
                "    </cv24:identite>\n" +
                "    <cv24:objectif status=\"stage\">\n" +
                "        <objectif>AAAadjajoiqjfia1141412389.,':;@~$#()&amp;?!$*-_=</objectif>\n" +
                "    </cv24:objectif>\n" +
                "    <cv24:competences>\n" +
                "        <diplôme niveau=\"5\">\n" +
                "            <date>2024-04-11</date>\n" +
                "            <institut>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</institut>\n" +
                "            <titre>bac</titre>\n" +
                "        </diplôme>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <titre>fhuadfh\tfaoiuzepeggzgezgeezgzhçf</titre>\n" +
                "        </certif>\n" +
                "        <certif>\n" +
                "            <datedeb>2024-04-11</datedeb>\n" +
                "            <datefin>2024-04-11</datefin>\n" +
                "            <titre>afu</titre>\n" +
                "        </certif>\n" +
                "    </cv24:competences>\n" +
                "    <cv24:divers>\n" +
                "        <lv lang=\"fr\" cert=\"CLAES\" nivs=\"B1\"/>\n" +
                "        <autre titre=\"sportif de haut niveau\" comment=\"natation\"></autre>\n" +
                "    </cv24:divers>\n" +
                "</cv24:cv24>";
        String xsdFile = "cv24.xsd";
        // WHEN & THEN
        assertThrows(SAXException.class, () -> {
            XMLValidator.validateXMLAgainstXSD(xmlFile,xsdFile);
        });
    }

}
