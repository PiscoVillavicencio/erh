package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.DistritoEntity;

import java.util.List;

public interface DistritoService {

    List<DistritoEntity> getAllDistritos();

    DistritoEntity getDistritoById(Long id);

}
