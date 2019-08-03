package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.repository.DepartamentoRepository;
import pe.gob.minsa.erh.repository.DocumentoRepository;

import java.util.List;

@Service
@Transactional
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;


    @Override
    public List<DocumentoEntity> listAll() {
        return (List<DocumentoEntity>) documentoRepository.findAll();
    }

    @Override
    public DocumentoEntity getById(Long id) {
        return documentoRepository.findOne(id);
    }

    @Override
    public DocumentoEntity saveOrUpdate(DocumentoEntity domainObject) {
        return documentoRepository.save(domainObject);
    }

    @Override
    public void delete(Long id) {
        documentoRepository.delete(id);
    }

}
