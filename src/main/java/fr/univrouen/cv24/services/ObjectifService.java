package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Objectif;
import fr.univrouen.cv24.repository.ObjectifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjectifService {

    @Autowired
    private ObjectifRepository objectifRepository;

    public Objectif saveObjectif(Objectif objectif, int id) {
        objectif.setcvID(id);
        return objectifRepository.save(objectif);
    }

    public Objectif buildObjectifForResumeCV(int id) {
        Objectif o = new Objectif();
        Objectif ObjectifSearch = objectifRepository.findByCvId(id);
        o.setObjectif(ObjectifSearch.getObjectif());
        o.setStatus(ObjectifSearch.getStatus());
        return o;
    }

    public Objectif getObjectifByID(int id) {
        return objectifRepository.findByCvId(id);
    }
}