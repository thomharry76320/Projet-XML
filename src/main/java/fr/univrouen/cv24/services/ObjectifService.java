package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Objectif;
import fr.univrouen.cv24.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service pour la gestion des éléments Objectif.
 */
@Service
public class ObjectifService {

    @Autowired
    private ObjectifRepository objectifRepository;

    /**
     * Sauvegarde un objectif associé à un CV dans la base de données.
     *
     * @param objectif L'objectif à sauvegarder.
     * @param id       L'identifiant du CV auquel l'objectif est associé.
     * @return L'objectif sauvegardé.
     */
    public Objectif saveObjectif(Objectif objectif, int id) {
        objectif.setcvID(id);
        return objectifRepository.save(objectif);
    }

    /**
     * Construit un objectif pour un CV à partir des données existantes.
     *
     * @param id L'identifiant du CV pour lequel l'objectif est construit.
     * @return L'objectif construit.
     */
    public Objectif buildObjectifForResumeCV(int id) {
        Objectif o = new Objectif();
        Objectif ObjectifSearch = objectifRepository.findByCvId(id);
        o.setObjectif(ObjectifSearch.getObjectif());
        o.setStatus(ObjectifSearch.getStatus());
        return o;
    }

    /**
     * Récupère l'objectif associé à un CV à partir de l'identifiant du CV.
     *
     * @param id L'identifiant du CV pour lequel l'objectif est récupéré.
     * @return L'objectif associé au CV spécifié.
     */
    public Objectif getObjectifByID(int id) {
        return objectifRepository.findByCvId(id);
    }
}
