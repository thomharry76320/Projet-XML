package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface représente un repository pour l'entité Detail.
 * Elle permet d'accéder aux données de la table associée à l'entité Detail dans la base de données.
 */
@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {

    /**
     * Récupère tous les détails associés à un CV spécifique.
     *
     * @param cvId L'identifiant du CV pour lequel on souhaite récupérer les détails.
     * @return Une liste contenant tous les détails associés au CV spécifié.
     */
    List<Detail> findAllByCvId(int cvId);
}
