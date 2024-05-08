package fr.univrouen.cv24.services;

import fr.univrouen.cv24.model.*;
import fr.univrouen.cv24.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfService {

    @Autowired
    private DetailRepository
            detailfRepository;

    public Prof saveProf(Prof prof, int id) {
        List<Detail> listD = prof.getDetail();
        if (listD != null) {
            for (Detail d : listD) {
                d.setcvID(id);
                detailfRepository.save(d);
            }
        }
        return prof;
    }

    public Prof getProfByID(int id) {
        Prof p = new Prof();
        p.setDetails(detailfRepository.findAllByCvId(id));
        return p;
    }

}
