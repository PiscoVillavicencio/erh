package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.model.entity.TratamientoEntity;

@Repository
public interface TratamientoRepository extends CrudRepository<TratamientoEntity, Long> { }
