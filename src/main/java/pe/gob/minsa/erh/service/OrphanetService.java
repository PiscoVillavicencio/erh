package pe.gob.minsa.erh.service;

import org.springframework.data.repository.CrudRepository;
import pe.gob.minsa.erh.model.entity.Orphanet;

import java.util.List;

public interface OrphanetService {

    List<Orphanet> getAllOrphanets();

    Orphanet getOrphanetById(Long id);

}
