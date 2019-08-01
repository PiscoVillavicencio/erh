package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.OrphanetEntity;
import pe.gob.minsa.erh.service.OrphanetService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orphanets")
public class OrphanetRestController {

    @Autowired
    private OrphanetService orphanetService;

    @GetMapping(value = "/", produces = "application/json")
    public List<OrphanetEntity> getOrphanet() {
        return orphanetService.getAllOrphanets();
    }

}
