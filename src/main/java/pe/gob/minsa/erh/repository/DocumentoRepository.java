package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;

@Repository
public interface DocumentoRepository extends CrudRepository<DocumentoEntity, Long> { }
