package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.ParentescoConverter;
import pe.gob.minsa.erh.model.dto.ParentescoDto;
import pe.gob.minsa.erh.model.entity.ParentescoEntity;
import pe.gob.minsa.erh.service.ParentescoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/parentescos")
public class ParentescoRestController {

    @Autowired
    private ParentescoService parentescoService;

    @Autowired
    private ParentescoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<ParentescoEntity> getEntities() {

        return parentescoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<ParentescoDto> getDtos() {
        return converter.toListDto(parentescoService.listAll());
    }

}
