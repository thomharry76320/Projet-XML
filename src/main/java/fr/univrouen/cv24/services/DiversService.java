package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.Langue;
import fr.univrouen.cv24.repository.AutreRepository;
import fr.univrouen.cv24.repository.LangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des éléments DIVERS.
 */
@Service
public class DiversService {

    @Autowired
    private LangueRepository langueRepository;

    @Autowired
    private AutreRepository autreRepository;

    /**
     * Enregistre les informations diverses d'un CV.
     *
     * @param div Les données diverses à enregistrer.
     * @param id L'identifiant du CV auquel les données diverses sont associées.
     * @return Les données diverses enregistrées.
     */
    public Divers saveDivers(Divers div, int id) {
        List<Langue> langues = div.getLv();
        if (langues != null) {
            for (Langue l : langues) {
                l.setcvID(id);
                langueRepository.save(l);
            }
        }
        List<Autre> autres = div.getAutre();
        if (autres != null) {
            for (Autre a : autres) {
                a.setcvID(id);
                autreRepository.save(a);
            }
        }
        return div;
    }

    /**
     * Récupère les informations diverses d'un CV en fonction de son identifiant.
     *
     * @param id L'identifiant du CV.
     * @return Les données diverses du CV correspondant à l'identifiant spécifié.
     */
    public Divers getDiversByID(int id) {
        Divers d = new Divers();
        d.setLv(langueRepository.findAllByCvId(id));
        d.setAutre(autreRepository.findAllByCvId(id));
        return d;
    }
}
