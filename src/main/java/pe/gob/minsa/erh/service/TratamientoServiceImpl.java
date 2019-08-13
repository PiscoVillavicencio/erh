package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.TratamientoEntity;
import pe.gob.minsa.erh.repository.TratamientoRepository;

import java.util.List;

@Service
@Transactional
public class TratamientoServiceImpl implements TratamientoService {

    @Autowired
    private TratamientoRepository tratamientoRepository;

    @Override
    public List<TratamientoEntity> listAll() {
        return (List<TratamientoEntity>) tratamientoRepository.findAll();
    }

    @Override
    public TratamientoEntity getById(Long id) {
        return tratamientoRepository.findOne(id);
    }

    @Override
    public TratamientoEntity saveOrUpdate(TratamientoEntity entity) {
        return tratamientoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        tratamientoRepository.delete(id);
    }

}
