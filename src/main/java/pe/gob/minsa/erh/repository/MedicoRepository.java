package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.IpressEntity;
import pe.gob.minsa.erh.model.entity.MedicoEntity;

@Repository
public interface MedicoRepository extends CrudRepository<MedicoEntity, Long> { }
