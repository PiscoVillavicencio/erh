package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;
import pe.gob.minsa.erh.repository.UbiDistritoRepository;

import java.util.List;

@Service
@Transactional
public class UbiDistritoServiceImpl implements UbiDistritoService {

    @Autowired
    UbiDistritoRepository ubiDistritoRepository;

    @Override
    public List<UbiDistritoEntity> listAll() {
        return (List<UbiDistritoEntity>) ubiDistritoRepository.findAll();
    }

    @Override
    public UbiDistritoEntity getById(Long id) {
        return ubiDistritoRepository.findOne(id);
    }

    @Override
    public UbiDistritoEntity saveOrUpdate(UbiDistritoEntity entity) {
        return ubiDistritoRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        ubiDistritoRepository.delete(id);
    }
}
