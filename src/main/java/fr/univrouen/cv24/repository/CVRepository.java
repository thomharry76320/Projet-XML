package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.CV24;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<CV24, Long> {

    @Modifying
    @Query("DELETE FROM CV24 e WHERE e.id = :valeur")
    int deleteByCustomQuery(@Param("valeur") int valeur);

    CV24 getCV24ById( int id);
}