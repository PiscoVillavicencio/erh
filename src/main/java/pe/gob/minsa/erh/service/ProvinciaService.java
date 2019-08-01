package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.ProvinciaEntity;

import java.util.List;

public interface ProvinciaService {

    List<ProvinciaEntity> getAllProvincias();

    ProvinciaEntity getProvinciaById(Long id);

}
