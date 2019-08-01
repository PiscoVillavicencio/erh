package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.DirectorEntity;

import java.util.List;

public interface DirectorService {

    List<DirectorEntity> getAllDirectores();

    DirectorEntity getDirectorById(Long id);

}
