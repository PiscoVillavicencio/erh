package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Cie10BloqueEntity;
import pe.gob.minsa.erh.repository.Cie10BloqueRepository;

import java.util.List;

@Service
@Transactional
public class Cie10BloqueServiceImpl implements Cie10BloqueService {

    @Autowired
    private Cie10BloqueRepository cie10BloqueRepository;

    @Override
    public List<Cie10BloqueEntity> listAll() {
        return (List<Cie10BloqueEntity>) cie10BloqueRepository.findAll();
    }

    @Override
    public Cie10BloqueEntity getById(Long id) {
        return cie10BloqueRepository.findOne(id);
    }

    @Override
    public Cie10BloqueEntity saveOrUpdate(Cie10BloqueEntity entity) {
        return cie10BloqueRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10BloqueRepository.delete(id);
    }
}
