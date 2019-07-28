package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.model.entity.Departamento;
import pe.gob.minsa.erh.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping(value="/", produces = "application/json")
    public List<Departamento> getDepartamentos() {
        return departamentoService.getAllDepartamentos();
    }

}
