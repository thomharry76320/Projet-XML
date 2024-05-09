package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.Certification;
import fr.univrouen.cv24.model.Competence;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.Titre;
import fr.univrouen.cv24.repository.CertifRepository;
import fr.univrouen.cv24.repository.DiplomeRepository;
import fr.univrouen.cv24.repository.TitreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Service gérant les opérations liées aux compétences dans le CV.
 */
@Service
public class CompetenceService {

    @Autowired
    private DiplomeRepository diplomeRepository;

    @Autowired
    private TitreRepository titreRepository;

    @Autowired
    private CertifRepository certifRepository;

    /**
     * Enregistre les compétences associées à un CV.
     *
     * @param comp Les compétences à enregistrer.
     * @param id L'identifiant du CV associé.
     * @return Les compétences enregistrées.
     */
    public Competence saveCompetence(Competence comp, int id) {
        List<Diplome> diplome = comp.getDiplome();
        for (Diplome d : diplome) {
            d.setcvID(id);
            diplomeRepository.save(d);
            List<Titre> titres = d.getTitre();
            if (titres != null) {
                for (Titre titre : titres) {
                    titre.setDiplomeID(d.getId());
                    titreRepository.save(titre);
                }
            }
        }
        List<Certification> cert = comp.getCertif();
        if (cert != null) {
            for (Certification c : cert) {
                c.setcvID(id);
                certifRepository.save(c);
            }
        }
        return comp;
    }

    /**
     * Construit les diplômes associés à un CV à afficher dans le résumé.
     *
     * @param id L'identifiant du CV.
     * @return Les compétences avec les diplômes construits pour le résumé.
     */
    public Competence buildDiplomeForResumeCV(int id) {
        List<Diplome> diplomes = diplomeRepository.findAllByCvId(id);
        Diplome d = searchMostRecentDiplome(diplomes);
        List<Titre> l = titreRepository.findAllByDiplomeid(d.getId());
        d.setTitre(l);
        Competence c = new Competence();
        List<Diplome> list = new ArrayList<>();
        list.add(d);
        c.setDiplome(list);
        return c;
    }

    /**
     * Récupère les compétences associées à un CV par son identifiant.
     *
     * @param id L'identifiant du CV.
     * @return Les compétences associées au CV.
     */
    public Competence getCompetenceByID(int id) {
        Competence c = new Competence();
        List<Diplome> diplomes = diplomeRepository.findAllByCvId(id);
        for (Diplome d : diplomes) {
            if (d != null) {
                List<Titre> l = titreRepository.findAllByDiplomeid(d.getId());
                d.setTitre(l);
            }
        }
        c.setDiplome(diplomes);
        c.setCertif(certifRepository.findAllByCvId(id));
        return c;
    }

    /**
     * Recherche le diplôme le plus récent parmi une liste de diplômes.
     *
     * @param list La liste de diplômes à rechercher.
     * @return Le diplôme le plus récent.
     */
    private Diplome searchMostRecentDiplome(List<Diplome> list) {
        // Trier la liste de diplômes en fonction du niveau (ordre décroissant)
        Collections.sort(list, new Comparator<Diplome>() {
            @Override
            public int compare(Diplome diplome1, Diplome diplome2) {
                int comparaisonNiveau = Integer.compare(diplome2.getNiveau(), diplome1.getNiveau());
                if (comparaisonNiveau != 0) {
                    return comparaisonNiveau;
                } else {
                    // Si les niveaux sont égaux, comparer les dates (du plus récent au plus ancien)
                    return diplome2.getDate().compareTo(diplome1.getDate());
                }
            }
        });
        return list.get(0);
    }
}