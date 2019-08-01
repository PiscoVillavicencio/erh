package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.ProvinciaEntity;

@Repository
public interface ProvinciaRepository extends CrudRepository<ProvinciaEntity, Long> {
}
