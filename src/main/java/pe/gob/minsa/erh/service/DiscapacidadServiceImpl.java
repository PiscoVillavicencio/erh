package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;
import pe.gob.minsa.erh.repository.DiscapacidadRepository;

import java.util.List;

@Service
@Transactional
public class DiscapacidadServiceImpl implements DiscapacidadService {

    @Autowired
    private DiscapacidadRepository discapacidadRepository;

    @Override
    public List<DiscapacidadEntity> listAll() {
        return (List<DiscapacidadEntity>) discapacidadRepository.findAll();
    }

    @Override
    public DiscapacidadEntity getById(Long id) {
        return discapacidadRepository.findOne(id);
    }

    @Override
    public DiscapacidadEntity saveOrUpdate(DiscapacidadEntity entity) {
        return discapacidadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        discapacidadRepository.delete(id);
    }

}
