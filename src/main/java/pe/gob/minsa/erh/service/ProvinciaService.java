package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.Provincia;

import java.util.List;

public interface ProvinciaService {

    List<Provincia> getAllProvincias();

    Provincia getProvinciaById(Long id);

}
