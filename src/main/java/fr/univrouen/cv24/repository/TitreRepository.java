package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface représente un référentiel (repository) pour la gestion des entités Titre.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface TitreRepository extends JpaRepository<Titre, Long> {

    /**
     * Récupère tous les titres associés à un diplôme spécifique.
     *
     * @param diplome_id L'identifiant du diplôme pour lequel on souhaite récupérer les titres.
     * @return Une liste de titres associés au diplôme spécifié.
     */
    List<Titre> findAllByDiplomeid(int diplome_id);
}
