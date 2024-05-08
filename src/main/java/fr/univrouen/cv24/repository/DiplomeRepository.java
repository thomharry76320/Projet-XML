package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Long> {

    List<Diplome> findAllByCvId(int cvId);
}