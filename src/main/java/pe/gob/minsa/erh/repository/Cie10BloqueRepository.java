package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.Cie10BloqueEntity;

@Repository
public interface Cie10BloqueRepository extends CrudRepository<Cie10BloqueEntity, Long> {
}
