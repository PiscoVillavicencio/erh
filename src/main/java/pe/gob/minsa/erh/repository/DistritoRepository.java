package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.Distrito;

@Repository
public interface DistritoRepository extends CrudRepository<Distrito, Long> {
}
