package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Identite;
import fr.univrouen.cv24.repository.IdentiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des éléments Identite.
 */
@Service
public class IdentiteService {

    @Autowired
    private IdentiteRepository identiteRepository;

    /**
     * Enregistre une identité dans la base de données.
     *
     * @param identite L'identité à enregistrer.
     * @param id L'ID du CV associé à cette identité.
     * @return L'identité enregistrée.
     */
    public Identite saveIdentite(Identite identite, int id) {
        identite.setcvID(id);
        return identiteRepository.save(identite);
    }

    /**
     * Recherche des utilisateurs déjà existants dans la base de données.
     *
     * @param genre Le genre de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param tel Le numéro de téléphone de l'utilisateur.
     * @return Une liste des identités correspondant aux critères de recherche.
     */
    public List<Identite> searchUserAlreadyExist(String genre, String nom, String prenom, String tel) {
        return identiteRepository.findByGenreAndNomAndPrenomAndTel(genre, nom, prenom, tel);
    }

    /**
     * Construit une identité pour un CV résumé.
     *
     * @param id L'ID du CV pour lequel construire l'identité.
     * @return L'identité construite.
     */
    public Identite buildIdentiteForResumeCV(int id) {
        Identite i = new Identite();
        Identite identiteSearch = identiteRepository.findByCvId(id);
        i.setPrenom(identiteSearch.getPrenom());
        i.setNom(identiteSearch.getNom());
        i.setGenre(identiteSearch.getGenre());
        return i;
    }

    /**
     * Récupère une identité à partir de son ID de CV.
     *
     * @param id L'ID du CV associé à l'identité.
     * @return L'identité correspondant à l'ID de CV donné.
     */
    public Identite getIdentiteById(int id) {
        return identiteRepository.findByCvId(id);
    }
}
