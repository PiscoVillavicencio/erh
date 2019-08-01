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
    private DistritoRepository distritoRepository;

    @Override
    public List<DistritoEntity> getAllDistritos() {

        return (List<DistritoEntity>) distritoRepository.findAll();
    }

    @Override
    public DistritoEntity getDistritoById(Long id) {

        return distritoRepository.findOne(id);
    }

}
