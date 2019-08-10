package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.Cie10CarpetaEntity;

@Repository
public interface Cie10CarpetaRepository extends CrudRepository<Cie10CarpetaEntity, Long> {
}
