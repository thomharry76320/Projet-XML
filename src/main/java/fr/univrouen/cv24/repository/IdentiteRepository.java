package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Identite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Cette interface définit un référentiel pour l'entité Identite.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface IdentiteRepository extends JpaRepository<Identite, Long> {

    /**
     * Recherche une liste d'identités en fonction du genre, du nom, du prénom et du numéro de téléphone.
     *
     * @param genre  Le genre de l'identité.
     * @param nom    Le nom de l'identité.
     * @param prenom Le prénom de l'identité.
     * @param tel    Le numéro de téléphone de l'identité.
     * @return Une liste d'identités correspondant aux critères de recherche.
     */
    List<Identite> findByGenreAndNomAndPrenomAndTel(String genre, String nom, String prenom, String tel);

    /**
     * Recherche une identité en fonction de l'identifiant du CV associé.
     *
     * @param cvId L'identifiant du CV associé à l'identité.
     * @return L'identité correspondant à l'identifiant du CV spécifié.
     */
    Identite findByCvId(int cvId);
}
