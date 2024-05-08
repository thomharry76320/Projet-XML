package fr.univrouen.cv24.exception;

import fr.univrouen.cv24.xml.XMLMessageBuilder;
import jakarta.persistence.PersistenceException;
import jakarta.xml.bind.JAXBException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.SAXException;

import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        XMLMessageBuilder messageBuilder = new XMLMessageBuilder();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "";

        if (e instanceof SAXException) {
            // Gestion des erreurs de parsing XML
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildErrorMessage("ERROR", "INVALID");
        } else if (e instanceof IOException) {
            // Gestion des erreurs de lecture de fichier
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildErrorMessage("ERROR", "Fichier Introuvable");
        } else if (e instanceof JAXBException) {
            // Gestion des erreurs de convertion xml
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildErrorMessage("ERROR", "CONVERSION FAILED");
        } else if (e instanceof ConstraintViolationException) {
            // Gestion des erreurs de duplication de cv
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildErrorMessage("ERROR", "DUPLICATED");
        } else if (e instanceof IllegalArgumentException) {
            // Gestion des erreurs de suppression
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildDeleteMessage(Integer.parseInt(e.getMessage()),"ERROR");
        } else if (e instanceof PersistenceException) {
            // Gestion des erreurs de suppression
            status = HttpStatus.BAD_REQUEST;
            message = messageBuilder.buildDeleteMessage(Integer.parseInt(e.getMessage()),"ERROR");
        }
        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_XML).body(message);
    }
}