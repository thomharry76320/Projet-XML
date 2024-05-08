package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Titre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitreRepository extends JpaRepository<Titre, Long> {

    List<Titre> findAllByDiplomeid(int diplome_id);
}