package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;

@Repository
public interface DiscapacidadRepository extends CrudRepository<DiscapacidadEntity, Long> { }
