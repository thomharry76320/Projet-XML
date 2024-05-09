package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Cette interface représente un référentiel pour la gestion des certifications.
 * Elle étend JpaRepository pour bénéficier des opérations CRUD de base.
 */
@Repository
public interface CertifRepository extends JpaRepository<Certification, Long> {

    /**
     * Récupère toutes les certifications associées à un CV spécifique.
     *
     * @param cvId L'identifiant du CV pour lequel récupérer les certifications.
     * @return Une liste de Certification associées au CV spécifié.
     */
    List<Certification> findAllByCvId(int cvId);
}
