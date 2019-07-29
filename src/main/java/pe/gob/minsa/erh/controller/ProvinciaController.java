package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.Provincia;
import pe.gob.minsa.erh.service.ProvinciaService;

import java.util.List;

@RestController
@RequestMapping(value = "/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value="/", produces = "application/json")
    public List<Provincia> getProvincias() {

        return provinciaService.getAllProvincias();
    }

}
