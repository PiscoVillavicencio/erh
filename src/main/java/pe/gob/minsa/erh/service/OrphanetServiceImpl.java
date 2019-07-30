package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Distrito;
import pe.gob.minsa.erh.model.entity.Orphanet;
import pe.gob.minsa.erh.repository.DistritoRepository;
import pe.gob.minsa.erh.repository.OrphanetRepository;

import java.util.List;

@Service
@Transactional
public class OrphanetServiceImpl implements OrphanetService {

    @Autowired
    private OrphanetRepository orphanetRepository;

    @Override
    public List<Orphanet> getAllOrphanets() {
        return (List<Orphanet>) orphanetRepository.findAll();
    }

    @Override
    public Orphanet getOrphanetById(Long id) {
        return orphanetRepository.findOne(id);
    }

}
