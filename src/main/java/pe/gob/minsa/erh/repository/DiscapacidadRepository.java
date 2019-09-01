package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface DiscapacidadRepository extends CrudRepository<DiscapacidadEntity, Long> {

    List<DiscapacidadEntity> findDiscapacidadEntitiesByPaciente(PacienteEntity entity);

}
