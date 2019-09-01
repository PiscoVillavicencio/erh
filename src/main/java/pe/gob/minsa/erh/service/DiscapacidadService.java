package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

public interface DiscapacidadService extends CRUDService<DiscapacidadEntity> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
