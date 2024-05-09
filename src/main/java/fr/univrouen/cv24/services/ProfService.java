package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Cette classe fournit des services pour la manipulation des objets Prof.
 */
@Service
public class ProfService {

    @Autowired
    private DetailRepository detailRepository;

    /**
     * Enregistre un objet Prof dans la base de données.
     *
     * @param prof L'objet Prof à enregistrer.
     * @param id   L'identifiant du CV auquel l'objet Prof est associé.
     * @return L'objet Prof enregistré.
     */
    public Prof saveProf(Prof prof, int id) {
        List<Detail> listD = prof.getDetail();
        if (listD != null) {
            for (Detail d : listD) {
                d.setcvID(id);
                detailRepository.save(d);
            }
        }
        return prof;
    }

    /**
     * Récupère un objet Prof à partir de son identifiant de CV.
     *
     * @param id L'identifiant du CV associé à l'objet Prof à récupérer.
     * @return L'objet Prof correspondant à l'identifiant spécifié.
     */
    public Prof getProfByID(int id) {
        Prof p = new Prof();
        p.setDetails(detailRepository.findAllByCvId(id));
        return p;
    }
}
