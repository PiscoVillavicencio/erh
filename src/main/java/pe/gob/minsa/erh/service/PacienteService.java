package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.PacienteEntity;

public interface PacienteService extends CRUDService<PacienteEntity> {

    PacienteEntity findPacienteEntityByNroDocumento(String nroDocuemento);
}
