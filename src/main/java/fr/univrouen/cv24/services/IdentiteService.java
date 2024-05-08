package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Identite;
import fr.univrouen.cv24.repository.IdentiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentiteService {

    @Autowired
    private IdentiteRepository identiteRepository;

    public Identite saveIdentite(Identite identite, int id) {
        identite.setcvID(id);
        return identiteRepository.save(identite);
    }
    public List<Identite> searchUserAlreadyExist(String genre, String nom, String prenom, String tel) {
        return identiteRepository.findByGenreAndNomAndPrenomAndTel(genre, nom, prenom,tel);
    }

    public Identite buildIdentiteForResumeCV(int id) {
        Identite i = new Identite();
        Identite identiteSearch = identiteRepository.findByCvId(id);
        i.setPrenom(identiteSearch.getPrenom());
        i.setNom(identiteSearch.getNom());
        i.setGenre(identiteSearch.getGenre());
        return i;
    }

    public Identite getIdentiteById(int id) {
        return identiteRepository.findByCvId(id);
    }
}