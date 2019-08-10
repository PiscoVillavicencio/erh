package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Cie10CategoriaEntity;
import pe.gob.minsa.erh.model.entity.UbiDepartamentoEntity;
import pe.gob.minsa.erh.repository.Cie10CategoriaRepository;
import pe.gob.minsa.erh.repository.UbiDepartamentoRepository;

import java.util.List;

@Service
@Transactional
public class Cie10CategoriaServiceImpl implements Cie10CategoriaService {

    @Autowired
    private Cie10CategoriaRepository cie10CategoriaRepository;

    @Override
    public List<Cie10CategoriaEntity> listAll() {
        return (List<Cie10CategoriaEntity>) cie10CategoriaRepository.findAll();
    }

    @Override
    public Cie10CategoriaEntity getById(Long id) {
        return cie10CategoriaRepository.findOne(id);
    }

    @Override
    public Cie10CategoriaEntity saveOrUpdate(Cie10CategoriaEntity entity) {
        return cie10CategoriaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        cie10CategoriaRepository.delete(id);
    }
}
