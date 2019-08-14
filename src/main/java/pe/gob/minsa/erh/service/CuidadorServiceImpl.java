package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.CuidadorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.repository.CuidadorRepository;

import java.util.List;

@Service
@Transactional
public class CuidadorServiceImpl implements CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    @Override
    public List<CuidadorEntity> listAll() {
        return (List<CuidadorEntity>) cuidadorRepository.findAll();
    }

    @Override
    public CuidadorEntity getById(Long id) {
        return cuidadorRepository.findOne(id);
    }

    @Override
    public CuidadorEntity saveOrUpdate(CuidadorEntity entity) {
        return cuidadorRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cuidadorRepository.delete(id);
    }

    @Override
    public List<CuidadorEntity> findCuidadorEntitiesByPacientes(PacienteEntity entity) {
        return cuidadorRepository.findCuidadorEntitiesByPacientes(entity);
    }

}
