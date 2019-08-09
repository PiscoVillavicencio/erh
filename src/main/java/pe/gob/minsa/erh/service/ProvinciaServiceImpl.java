package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.ProvinciaEntity;
import pe.gob.minsa.erh.repository.ProvinciaRepository;

import java.util.List;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<ProvinciaEntity> listAll() {
        return (List<ProvinciaEntity>) provinciaRepository.findAll();
    }

    @Override
    public ProvinciaEntity getById(Long id) {
        return provinciaRepository.findOne(id);
    }

    @Override
    public ProvinciaEntity saveOrUpdate(ProvinciaEntity entity) {
        return provinciaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        provinciaRepository.delete(id);
    }

}
