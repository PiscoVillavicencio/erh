package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;

@Repository
public interface EnfermedadRepository extends CrudRepository<EnfermedadEntity, Long> { }
