package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.Langue;
import fr.univrouen.cv24.repository.AutreRepository;
import fr.univrouen.cv24.repository.LangueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiversService {

    @Autowired
    private LangueRepository langueRepository;

    @Autowired
    private AutreRepository autreRepository;

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

    public Divers getDiversByID(int id) {
        Divers d = new Divers();
        d.setLv(langueRepository.findAllByCvId(id));
        d.setAutre(autreRepository.findAllByCvId(id));
        return d;
    }
}