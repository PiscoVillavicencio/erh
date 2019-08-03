package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends CrudRepository<DepartamentoEntity, Long> { }
