package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.Distrito;
import pe.gob.minsa.erh.service.DistritoService;

import java.util.List;

@RestController
@RequestMapping(value = "/distritos")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping(value="/", produces = "application/json")
    public List<Distrito> getDistritos() {

        return distritoService.getAllDistritos();
    }

}
