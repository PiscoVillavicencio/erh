package pe.gob.minsa.erh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.gob.minsa.erh.model.entity.Ipress;
import pe.gob.minsa.erh.model.entity.Provincia;

@Repository
public interface IpressRepository extends CrudRepository<Ipress, Long> {
}
