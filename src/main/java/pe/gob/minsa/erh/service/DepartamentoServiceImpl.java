package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;
import pe.gob.minsa.erh.repository.DepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<DepartamentoEntity> getAllDepartamentos() {

        return (List<DepartamentoEntity>) departamentoRepository.findAll();
    }

    @Override
    public DepartamentoEntity getDepartamentoById(Long id) {

        return departamentoRepository.findOne(id);
    }

}
