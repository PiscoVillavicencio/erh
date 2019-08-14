package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.CuidadorEntity;
import pe.gob.minsa.erh.model.entity.DirectorEntity;

import java.util.List;

@Repository
public interface CuidadorRepository extends CrudRepository<CuidadorEntity, Long> { }
