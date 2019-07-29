package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.model.entity.Provincia;
import pe.gob.minsa.erh.repository.DepartamentoRepository;
import pe.gob.minsa.erh.repository.ProvinciaRepository;

import java.util.List;

@Service
@Transactional
public class ProvinciaServiceImpl implements ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> getAllProvincias() {

        return (List<Provincia>) provinciaRepository.findAll();
    }

    @Override
    public Provincia getProvinciaById(Long id) {

        return provinciaRepository.findOne(id);
    }

}
