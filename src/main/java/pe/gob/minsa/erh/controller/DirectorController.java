package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.Director;
import pe.gob.minsa.erh.service.DirectorService;

import java.util.List;

@RestController
@RequestMapping(value = "/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping(value="/", produces = "application/json")
    public List<Director> getDirectores() {
        return directorService.getAllDirectores();
    }

}
