package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.ProvinciaEntity;
import pe.gob.minsa.erh.service.ProvinciaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/provincias")
public class ProvinciaRestController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value = "/", produces = "application/json")
    public List<ProvinciaEntity> getProvincias() {

        return provinciaService.listAll();
    }

}
