package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.repository.EnfermedadRepository;

import java.util.List;

@Service
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;


    @Override
    public List<EnfermedadEntity> listAll() {
        return (List<EnfermedadEntity>) enfermedadRepository.findAll();
    }

    @Override
    public EnfermedadEntity getById(Long id) {
        return enfermedadRepository.findOne(id);
    }

    @Override
    public EnfermedadEntity saveOrUpdate(EnfermedadEntity entity) {
        return enfermedadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        enfermedadRepository.delete(id);
    }

}
