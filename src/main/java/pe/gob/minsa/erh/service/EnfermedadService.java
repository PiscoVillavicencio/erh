package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

public interface EnfermedadService extends CRUDService<EnfermedadEntity> {

    List<EnfermedadEntity> findEnfermedadEntitiesByPaciente(PacienteEntity entity);

}
