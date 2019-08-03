package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.DirectorEntity;

@Repository
public interface DirectorRepository extends CrudRepository<DirectorEntity, Long> { }
