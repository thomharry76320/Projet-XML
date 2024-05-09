package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface représente un référentiel de données pour les diplômes.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

    /**
     * Récupère tous les diplômes associés à un CV spécifique.
     *
     * @param cvId L'identifiant du CV pour lequel on souhaite récupérer les diplômes.
     * @return Une liste de diplômes associés au CV spécifié.
     */
    List<Diplome> findAllByCvId(int cvId);
}
