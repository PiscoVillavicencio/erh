package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.UbiProvinciaEntity;

@Repository
public interface UbiProvinciaRepository extends CrudRepository<UbiProvinciaEntity, Long> {
}
