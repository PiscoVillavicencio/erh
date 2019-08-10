package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;
import pe.gob.minsa.erh.repository.DistritoRepository;

import java.util.List;

@Service
@Transactional
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    DistritoRepository distritoRepository;

    @Override
    public List<UbiDistritoEntity> listAll() {
        return (List<UbiDistritoEntity>) distritoRepository.findAll();
    }

    @Override
    public UbiDistritoEntity getById(Long id) {
        return distritoRepository.findOne(id);
    }

    @Override
    public UbiDistritoEntity saveOrUpdate(UbiDistritoEntity entity) {
        return distritoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        distritoRepository.delete(id);
    }
}
