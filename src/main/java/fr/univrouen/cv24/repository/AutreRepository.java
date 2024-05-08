package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Autre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutreRepository extends JpaRepository<Autre, Long> {

    List<Autre> findAllByCvId(int cvId);
}