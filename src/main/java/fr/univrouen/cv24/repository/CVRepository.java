package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.CV24;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Cette interface définit un référentiel pour la gestion des entités CV24.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface CVRepository extends JpaRepository<CV24, Long> {

    /**
     * Cette méthode exécute une requête de suppression personnalisée dans la base de données.
     *
     * @param valeur L'identifiant de l'entité CV24 à supprimer.
     * @return Le nombre d'entités supprimées.
     */
    @Modifying
    @Query("DELETE FROM CV24 e WHERE e.id = :valeur")
    int deleteByCustomQuery(@Param("valeur") int valeur);

    /**
     * Cette méthode récupère une entité CV24 à partir de son identifiant.
     *
     * @param id L'identifiant de l'entité CV24.
     * @return L'entité CV24 correspondante, ou null si aucune entité n'est trouvée.
     */
    CV24 getCV24ById(int id);
}
