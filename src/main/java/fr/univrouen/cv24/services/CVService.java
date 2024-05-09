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

/**
 * Service pour la gestion des CV.
 */
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

    /**
     * Sauvegarde un CV dans la base de données s'il n'existe pas déjà, sinon renvoie une erreur.
     *
     * @param cv Le CV à sauvegarder.
     * @return Le CV sauvegardé.
     * @throws ConstraintViolationException Si le CV existe déjà dans la base de données.
     */
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

    /**
     * Supprime le CV correspondant à l'ID spécifié.
     *
     * @param id L'ID du CV à supprimer.
     * @return true si le CV est supprimé avec succès, sinon false.
     * @throws IllegalArgumentException Si aucun CV correspondant à l'ID spécifié n'est trouvé.
     * @throws PersistenceException      Si le CV existe toujours après la suppression.
     */
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

    /**
     * Renvoie une liste de tous les CV sous forme résumée.
     *
     * @return La liste des CV résumés.
     */
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

    /**
     * Renvoie le CV complet correspondant à l'ID spécifié.
     *
     * @param id L'ID du CV à récupérer.
     * @return Le CV complet correspondant à l'ID spécifié.
     * @throws IllegalArgumentException Si aucun CV correspondant à l'ID spécifié n'est trouvé.
     */
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