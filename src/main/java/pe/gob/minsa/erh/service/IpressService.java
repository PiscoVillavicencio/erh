package pe.gob.minsa.erh.service;

import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.model.entity.Ipress;

import java.util.List;

public interface IpressService {

    List<Ipress> getAllIpresses();

    Ipress getIpressById(Long id);

}
