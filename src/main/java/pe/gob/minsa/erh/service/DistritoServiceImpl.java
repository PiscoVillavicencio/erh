package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.model.entity.Distrito;
import pe.gob.minsa.erh.model.entity.Provincia;
import pe.gob.minsa.erh.repository.DepartamentoRepository;
import pe.gob.minsa.erh.repository.DistritoRepository;
import pe.gob.minsa.erh.repository.ProvinciaRepository;

import java.util.List;

@Service
@Transactional
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private DistritoRepository distritoRepository;

    @Override
    public List<Distrito> getAllDistritos() {

        return (List<Distrito>) distritoRepository.findAll();
    }

    @Override
    public Distrito getDistritoById(Long id) {

        return distritoRepository.findOne(id);
    }

}
