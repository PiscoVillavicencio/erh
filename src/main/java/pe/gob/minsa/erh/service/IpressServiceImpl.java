package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.model.entity.Ipress;
import pe.gob.minsa.erh.repository.IpressRepository;

import java.util.List;

@Service
@Transactional
public class IpressServiceImpl implements IpressService {

    @Autowired
    private IpressRepository ipressRepository;

    @Override
    public List<Ipress> getAllIpresses() {
        return (List<Ipress>) ipressRepository.findAll();
    }

    @Override
    public Ipress getIpressById(Long id) {
        return ipressRepository.findOne(id);
    }

}
