package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.model.entity.TratamientoEntity;

import java.util.List;

public interface TratamientoService extends CRUDService<TratamientoEntity> {

    List<TratamientoEntity> findTratamientoEntitiesByEnfermedad(EnfermedadEntity entity);

}
