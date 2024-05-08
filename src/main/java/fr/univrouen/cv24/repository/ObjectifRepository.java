package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Objectif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectifRepository extends JpaRepository<Objectif, Long> {
    Objectif findByCvId(int cvId);
}