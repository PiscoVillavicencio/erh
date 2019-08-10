package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Cie10CarpetaEntity;
import pe.gob.minsa.erh.repository.Cie10CarpetaRepository;

import java.util.List;

@Service
@Transactional
public class Cie10CarpetaServiceImpl implements Cie10CarpetaService {

    @Autowired
    private Cie10CarpetaRepository cie10CarpetaRepository;

    @Override
    public List<Cie10CarpetaEntity> listAll() {
        return (List<Cie10CarpetaEntity>) cie10CarpetaRepository.findAll();
    }

    @Override
    public Cie10CarpetaEntity getById(Long id) {
        return cie10CarpetaRepository.findOne(id);
    }

    @Override
    public Cie10CarpetaEntity saveOrUpdate(Cie10CarpetaEntity entity) {
        return cie10CarpetaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10CarpetaRepository.delete(id);
    }
}
