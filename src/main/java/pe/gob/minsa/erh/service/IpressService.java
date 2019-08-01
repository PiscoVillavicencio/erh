package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.IpressEntity;

import java.util.List;

public interface IpressService {

    List<IpressEntity> getAllIpresses();

    IpressEntity getIpressById(Long id);

}
