package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.CV24;
import fr.univrouen.cv24.model.Identite;
import fr.univrouen.cv24.repository.CVRepository;
import fr.univrouen.cv24.repository.IdentiteRepository;
import jakarta.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVService {

    @Autowired
    private CVRepository cvRepository;

    @Autowired
    private IdentiteRepository identiteRepository;

    @Autowired
    private IdentiteService identiteService;

    @Autowired
    private ObjectifService objectifService;

    @Autowired
    private  ProfService profService;

    @Autowired
    private CompetenceService compService;

    @Autowired
    private DiversService diversService;

    // Sauvegarde un CV dans le base de donnée si il n'existe pas déja sinon renvoie une erreur.
    public CV24 saveCV(CV24 cv) {
        List<Identite> i = identiteService.searchUserAlreadyExist(cv.getIdentite().getGenre(), cv.getIdentite().getNom(),
                cv.getIdentite().getPrenom(),cv.getIdentite().getTel());
        if (i.isEmpty()) {
            CV24 CVsauvegarded = cvRepository.save(cv);
            // On récupère l'id du CV que l'on vient de sauvegarder
            int idCV = CVsauvegarded.getId();
            // On ajoute à la base de données les différents éléments du CV
            identiteService.saveIdentite(cv.getIdentite(), idCV);
            objectifService.saveObjectif(cv.getObjectif(), idCV);
            compService.saveCompetence(cv.getCompetences(), idCV);
            if (cv.getProf() != null) {
                profService.saveProf(cv.getProf(), idCV);
            }

            if (cv.getDivers() != null) {
                diversService.saveDivers(cv.getDivers(), idCV);
            }
            return CVsauvegarded;
        } else {
            throw new ConstraintViolationException("cv deja enregistrer", null, null);
        }
    }

    // Supprime le CV qui correspond à l'id en paramètre et si cette id ne correspond à aucun CV alors renvoie une erreur.
    public boolean deleteCV(int id) {
        if (!cvRepository.existsById((long) id)) {
            throw new IllegalArgumentException(String.valueOf(id));
        }
        cvRepository.deleteById((long) id);
        if (cvRepository.existsById((long) id)) {
            throw new PersistenceException(String.valueOf(id));
        }
        return true;
    }

    // Renvoie la liste de tout les CV de manières résumer
    public List<CV24> getResumeCV() {
        List<CV24> l = cvRepository.findAll();
        for (CV24 cv : l) {
            int id = cv.getId();
            cv.setIdentite(identiteService.buildIdentiteForResumeCV(id));
            cv.setObjectif(objectifService.buildObjectifForResumeCV(id));
            cv.setCompetences(compService.buildDiplomeForResumeCV(id));
        }
        return l;
    }

    // Renvoie le CV complet correspondant à l'id sinon renvoie une erreur.
    public CV24 getCVById(int id) {
        if (!cvRepository.existsById((long) id)) {
            throw new IllegalArgumentException(String.valueOf(id));
        }
        CV24 cv = cvRepository.getCV24ById(id);
        cv.setIdentite(identiteService.getIdentiteById(id));
        cv.setObjectif(objectifService.getObjectifByID(id));
        cv.setProf(profService.getProfByID(id));
        cv.setCompetences(compService.getCompetenceByID(id));
        cv.setDivers(diversService.getDiversByID(id));
        return cv;
    }
}