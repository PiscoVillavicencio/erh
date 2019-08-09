package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.IpressEntity;
import pe.gob.minsa.erh.repository.IpressRepository;

import java.util.List;

@Service
@Transactional
public class IpressServiceImpl implements IpressService {

    @Autowired
    private IpressRepository ipressRepository;

    @Override
    public List<IpressEntity> listAll() {
        return (List<IpressEntity>) ipressRepository.findAll();
    }

    @Override
    public IpressEntity getById(Long id) {
        return ipressRepository.findOne(id);
    }

    @Override
    public IpressEntity saveOrUpdate(IpressEntity entity) {
        return ipressRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        ipressRepository.delete(id);
    }

}
