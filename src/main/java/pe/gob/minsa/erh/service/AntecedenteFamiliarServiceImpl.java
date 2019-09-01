package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.AntecedenteFamiliarEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.repository.AntecedenteFamiliarRepository;

import java.util.List;

@Service
@Transactional
public class AntecedenteFamiliarServiceImpl implements AntecedenteFamiliarService {

    @Autowired
    private AntecedenteFamiliarRepository antecedenteFamiliarRepository;

    @Override
    public List<AntecedenteFamiliarEntity> listAll() {
        return (List<AntecedenteFamiliarEntity>) antecedenteFamiliarRepository.findAll();
    }

    @Override
    public AntecedenteFamiliarEntity getById(Long id) {
        return antecedenteFamiliarRepository.findOne(id);
    }

    @Override
    public AntecedenteFamiliarEntity saveOrUpdate(AntecedenteFamiliarEntity entity) {
        return antecedenteFamiliarRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        antecedenteFamiliarRepository.delete(id);
    }

    @Override
    public List<AntecedenteFamiliarEntity> findAntecedenteFamiliarEntitiesByPaciente(PacienteEntity entity) {
        return antecedenteFamiliarRepository.findAntecedenteFamiliarEntitiesByPaciente(entity);
    }
}
