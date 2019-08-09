package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

@Repository
public interface PacienteRepository extends CrudRepository<PacienteEntity, Long> { }
