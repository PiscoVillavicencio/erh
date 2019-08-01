package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/directores")
public class DirectorRestController {

    @Autowired
    private DirectorService directorService;

    @GetMapping(value = "/", produces = "application/json")
    public List<DirectorEntity> getDirectores() {

        return directorService.listAll();
    }

}
