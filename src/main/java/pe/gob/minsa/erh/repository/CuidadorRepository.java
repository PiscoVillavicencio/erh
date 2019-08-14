package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.CuidadorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;

import java.util.List;

@Repository
public interface CuidadorRepository extends CrudRepository<CuidadorEntity, Long> {

/*    @Query("select c from CuidadorEntity c inner join c.pacientes p where p.id =:pacienteId")
    List<CuidadorEntity> findByPacienteId(@Param("pacienteId") Long pacienteId);*/

    List<CuidadorEntity> findCuidadorEntitiesByPacientes(PacienteEntity entity);

}
