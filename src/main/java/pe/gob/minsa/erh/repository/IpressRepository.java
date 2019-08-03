package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.IpressEntity;

@Repository
public interface IpressRepository extends CrudRepository<IpressEntity, Long> { }
