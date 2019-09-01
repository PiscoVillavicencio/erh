package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.model.entity.TratamientoEntity;

import java.util.List;

@Repository
public interface TratamientoRepository extends CrudRepository<TratamientoEntity, Long> {

    List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity);

}
