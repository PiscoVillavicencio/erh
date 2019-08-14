package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.AntecedenteFamiliarEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

public interface AntecedenteFamiliarService extends CRUDService<AntecedenteFamiliarEntity> {

    List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPacientes(PacienteEntity entity);

}
