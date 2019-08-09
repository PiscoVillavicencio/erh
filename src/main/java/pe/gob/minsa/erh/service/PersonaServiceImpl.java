package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.repository.DirectorRepository;
import pe.gob.minsa.erh.repository.PersonaRepository;

import java.util.List;

@Service
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaEntity> listAll() {
        return (List<PersonaEntity>) personaRepository.findAll();
    }

    @Override
    public PersonaEntity getById(Long id) {
        return personaRepository.findOne(id);
    }

    @Override
    public PersonaEntity saveOrUpdate(PersonaEntity entity) {
        return personaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        personaRepository.delete(id);
    }

}
