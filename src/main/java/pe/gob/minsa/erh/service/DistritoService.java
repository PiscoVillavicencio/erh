package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.Distrito;

import java.util.List;

public interface DistritoService {

    List<Distrito> getAllDistritos();

    Distrito getDistritoById(Long id);

}
