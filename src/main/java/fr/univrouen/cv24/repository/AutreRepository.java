package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Autre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface est un référentiel pour les entités de type Autre.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base sur les entités Autre.
 */
@Repository
public interface AutreRepository extends JpaRepository<Autre, Long> {

    /**
     * Récupère tous les éléments Autre associés à un identifiant de CV donné.
     *
     * @param cvId L'identifiant du CV pour lequel récupérer les éléments Autre.
     * @return Une liste contenant tous les éléments Autre associés à l'identifiant du CV spécifié.
     */
    List<Autre> findAllByCvId(int cvId);
}