package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.DistritoEntity;
import pe.gob.minsa.erh.service.DistritoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/distritos")
public class DistritoRestController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping(value = "/", produces = "application/json")
    public List<DistritoEntity> getDistritos() {

        return distritoService.listAll();
    }

}
