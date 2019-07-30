package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import pe.gob.minsa.erh.model.entity.Orphanet;

public interface OrphanetRepository extends CrudRepository<Orphanet, Long> {
}
