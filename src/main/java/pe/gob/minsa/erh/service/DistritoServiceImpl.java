package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DistritoEntity;
import pe.gob.minsa.erh.repository.DistritoRepository;

import java.util.List;

@Service
@Transactional
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> listAll() {
        return (List<DistritoEntity>) distritoRepository.findAll();
    }

    @Override
    public DistritoEntity getById(Long id) {
        return distritoRepository.findOne(id);
    }

    @Override
    public DistritoEntity saveOrUpdate(DistritoEntity entity) {
        return distritoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        distritoRepository.delete(id);
    }
}
