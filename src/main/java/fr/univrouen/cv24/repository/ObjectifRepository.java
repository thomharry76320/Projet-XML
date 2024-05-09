package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface représentant un référentiel (repository) pour la gestion des objectifs dans le contexte de l'application.
 * Cette interface étend JpaRepository pour bénéficier des opérations CRUD de base sur les objets Objectif.
 */
@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {

    /**
     * Recherche un objectif par l'identifiant du CV associé.
     *
     * @param cvId L'identifiant du CV pour lequel on recherche l'objectif.
     * @return L'objectif trouvé, ou null s'il n'existe aucun objectif associé à l'identifiant du CV.
     */
    Objectif findByCvId(int cvId);
}
