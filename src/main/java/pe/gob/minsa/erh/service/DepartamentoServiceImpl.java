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
    public List<DepartamentoEntity> listAll() {
        return (List<DepartamentoEntity>) departamentoRepository.findAll();
    }

    @Override
    public DepartamentoEntity getById(Long id) {
        return departamentoRepository.findOne(id);
    }

    @Override
    public DepartamentoEntity saveOrUpdate(DepartamentoEntity entity) {
        return departamentoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departamentoRepository.delete(id);
    }
}
