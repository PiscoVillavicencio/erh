package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.CuidadorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

public interface CuidadorService extends CRUDService<CuidadorEntity> {

    List<CuidadorEntity> findCuidadorEntitiesByPacientes(PacienteEntity entity);

}
