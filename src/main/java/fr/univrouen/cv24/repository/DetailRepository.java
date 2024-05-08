package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findAllByCvId(int cvId);
}