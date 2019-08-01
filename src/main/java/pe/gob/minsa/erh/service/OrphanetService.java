package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.OrphanetEntity;

import java.util.List;

public interface OrphanetService {

    List<OrphanetEntity> getAllOrphanets();

    OrphanetEntity getOrphanetById(Long id);

}
