package fr.univrouen.cv24.repository;

import fr.univrouen.cv24.model.Certification;
import fr.univrouen.cv24.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertifRepository extends JpaRepository<Certification, Long> {

    List<Certification> findAllByCvId(int cvId);
}