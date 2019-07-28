package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.Departamento;

import java.util.List;

public interface DepartamentoService {

    List<Departamento> getAllDepartamentos();

    Departamento getDepartamentoById(Long id);

}
