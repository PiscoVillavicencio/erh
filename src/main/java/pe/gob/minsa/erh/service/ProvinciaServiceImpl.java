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
    public List<ProvinciaEntity> getAllProvincias() {

        return (List<ProvinciaEntity>) provinciaRepository.findAll();
    }

    @Override
    public ProvinciaEntity getProvinciaById(Long id) {

        return provinciaRepository.findOne(id);
    }

}
