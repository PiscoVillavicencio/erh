package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DepartamentoConverter;
import pe.gob.minsa.erh.model.dto.DepartamentoDto;
import pe.gob.minsa.erh.model.entity.DepartamentoEntity;
import pe.gob.minsa.erh.service.DepartamentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departamentos")
public class DepartamentoRestController {

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private DepartamentoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DepartamentoEntity> getEntities() {

        return departamentoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DepartamentoDto> getDtos() {
        return converter.toListDto(departamentoService.listAll());
    }

}
