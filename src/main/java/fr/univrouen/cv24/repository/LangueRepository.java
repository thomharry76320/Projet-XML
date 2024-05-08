package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Langue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LangueRepository extends JpaRepository<Langue, Long> {
    List<Langue> findAllByCvId(int cvId);
}
