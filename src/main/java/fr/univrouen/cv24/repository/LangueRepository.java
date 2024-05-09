package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface représente un référentiel (repository) pour l'entité Langue.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface LangueRepository extends JpaRepository<Langue, Long> {

    /**
     * Trouve toutes les langues associées à un CV spécifique.
     *
     * @param cvId L'identifiant du CV pour lequel les langues doivent être recherchées.
     * @return Une liste de langues associées au CV spécifié.
     */
    List<Langue> findAllByCvId(int cvId);
}
