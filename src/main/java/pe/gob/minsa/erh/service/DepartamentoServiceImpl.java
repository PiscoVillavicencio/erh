package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.UbiDepartamentoEntity;
import pe.gob.minsa.erh.repository.DepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;


    @Override
    public List<UbiDepartamentoEntity> listAll() {
        return (List<UbiDepartamentoEntity>) departamentoRepository.findAll();
    }

    @Override
    public UbiDepartamentoEntity getById(Long id) {
        return departamentoRepository.findOne(id);
    }

    @Override
    public UbiDepartamentoEntity saveOrUpdate(UbiDepartamentoEntity entity) {
        return departamentoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departamentoRepository.delete(id);
    }
}
