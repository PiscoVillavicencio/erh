package pe.gob.minsa.erh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.repository.DirectorRepository;

import java.util.List;

@Service
@Transactional
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorEntity> listAll() {
        return (List<DirectorEntity>) directorRepository.findAll();
    }

    @Override
    public DirectorEntity getById(Long id) {
        return directorRepository.findOne(id);
    }

    @Override
    public DirectorEntity saveOrUpdate(DirectorEntity directorEntity) {
        return directorRepository.save(directorEntity);
    }

    @Override
    public void delete(Long id) {
        directorRepository.delete(id);
    }

}
