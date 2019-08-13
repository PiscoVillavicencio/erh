package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.repository.DocumentoEnfermedadRepository;

import java.util.List;

@Service
@Transactional
public class DocumentoEnfermedadServiceImpl implements DocumentoEnfermedadService {

    @Autowired
    private DocumentoEnfermedadRepository documentoEnfermedadRepository;


    @Override
    public List<DocumentoEnfermedadEntity> listAll() {
        return (List<DocumentoEnfermedadEntity>) documentoEnfermedadRepository.findAll();
    }

    @Override
    public DocumentoEnfermedadEntity getById(Long id) {
        return documentoEnfermedadRepository.findOne(id);
    }

    @Override
    public DocumentoEnfermedadEntity saveOrUpdate(DocumentoEnfermedadEntity entity) {
        return documentoEnfermedadRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        documentoEnfermedadRepository.delete(id);
    }

}
