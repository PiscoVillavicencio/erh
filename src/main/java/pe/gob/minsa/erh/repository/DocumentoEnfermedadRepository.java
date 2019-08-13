package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;

@Repository
public interface DocumentoEnfermedadRepository extends CrudRepository<DocumentoEnfermedadEntity, Long> { }
