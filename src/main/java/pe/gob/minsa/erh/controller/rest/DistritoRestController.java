package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DistritoConverter;
import pe.gob.minsa.erh.model.dto.DistritoDto;
import pe.gob.minsa.erh.model.entity.DistritoEntity;
import pe.gob.minsa.erh.service.DistritoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/distritos")
public class DistritoRestController {

    @Autowired
    private DistritoService distritoService;

    @Autowired
    private DistritoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DistritoEntity> getEntities() {

        return distritoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DistritoDto> getDtos() {

        return converter.toListDto(distritoService.listAll());
    }

}
