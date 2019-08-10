package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;

@Repository
public interface DistritoRepository extends CrudRepository<UbiDistritoEntity, Long> { }
