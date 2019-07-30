package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.Director;
import pe.gob.minsa.erh.model.entity.Orphanet;

import java.util.List;

public interface DirectorService {

    List<Director> getAllDirectores();

    Director getDirectorById(Long id);

}
