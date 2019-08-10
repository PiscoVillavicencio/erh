package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.UbiProvinciaEntity;
import pe.gob.minsa.erh.repository.ProvinciaRepository;

import java.util.List;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<UbiProvinciaEntity> listAll() {
        return (List<UbiProvinciaEntity>) provinciaRepository.findAll();
    }

    @Override
    public UbiProvinciaEntity getById(Long id) {
        return provinciaRepository.findOne(id);
    }

    @Override
    public UbiProvinciaEntity saveOrUpdate(UbiProvinciaEntity entity) {
        return provinciaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        provinciaRepository.delete(id);
    }

}
