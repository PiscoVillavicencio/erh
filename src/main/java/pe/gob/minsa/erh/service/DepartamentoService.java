package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.DepartamentoEntity;

import java.util.List;

public interface DepartamentoService {

    List<DepartamentoEntity> getAllDepartamentos();

    DepartamentoEntity getDepartamentoById(Long id);

}
