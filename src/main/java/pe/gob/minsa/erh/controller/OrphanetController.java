package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.model.entity.Orphanet;
import pe.gob.minsa.erh.service.DepartamentoService;
import pe.gob.minsa.erh.service.OrphanetService;

import java.util.List;

@RestController
@RequestMapping(value = "/orphanets")
public class OrphanetController {

    @Autowired
    private OrphanetService orphanetService;

    @GetMapping(value="/", produces = "application/json")
    public List<Orphanet> getOrphanet() {
        return orphanetService.getAllOrphanets();
    }

}
