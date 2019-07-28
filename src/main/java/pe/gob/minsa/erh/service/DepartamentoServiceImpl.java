package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.repository.DepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> getAllDepartamentos() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    @Override
    public Departamento getDepartamentoById(Long id) {
        return departamentoRepository.findOne(id);
    }

}
