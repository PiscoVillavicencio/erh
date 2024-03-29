package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.OrphanetEntity;
import pe.gob.minsa.erh.repository.OrphanetRepository;

import java.util.List;

@Service
@Transactional
public class OrphanetServiceImpl implements OrphanetService {

    @Autowired
    private OrphanetRepository orphanetRepository;

    @Override
    public List<OrphanetEntity> listAll() {
        return (List<OrphanetEntity>) orphanetRepository.findAll();
    }

    @Override
    public OrphanetEntity getById(Long id) {
        return orphanetRepository.findOne(id);
    }

    @Override
    public OrphanetEntity saveOrUpdate(OrphanetEntity entity) {
        return orphanetRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        orphanetRepository.delete(id);
    }

}
