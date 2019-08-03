package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;
import pe.gob.minsa.erh.model.entity.ParentescoEntity;
import pe.gob.minsa.erh.repository.DepartamentoRepository;
import pe.gob.minsa.erh.repository.ParentescoRepository;

import java.util.List;

@Service
@Transactional
public class ParentescoServiceImpl implements ParentescoService {

    @Autowired
    private ParentescoRepository parentescoRepository;

    @Override
    public List<ParentescoEntity> listAll() {
        return (List<ParentescoEntity>) parentescoRepository.findAll();
    }

    @Override
    public ParentescoEntity getById(Long id) {
        return parentescoRepository.findOne(id);
    }

    @Override
    public ParentescoEntity saveOrUpdate(ParentescoEntity domainObject) {
        return parentescoRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        parentescoRepository.delete(id);
    }
}
