package fr.univrouen.cv24.repository;


import fr.univrouen.cv24.model.Identite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdentiteRepository extends JpaRepository<Identite, Long> {
    List<Identite> findByGenreAndNomAndPrenomAndTel(String genre, String nom, String prenom, String tel);

    Identite findByCvId(int cvId);
}