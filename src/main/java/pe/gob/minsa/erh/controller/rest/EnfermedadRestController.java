package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DocumentoEnfermedadConverter;
import pe.gob.minsa.erh.converter.EnfermedadConverter;
import pe.gob.minsa.erh.model.dto.DocumentoEnfermedadDto;
import pe.gob.minsa.erh.model.dto.EnfermedadDto;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.service.DocumentoEnfermedadService;
import pe.gob.minsa.erh.service.EnfermedadService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enfermedades")
public class EnfermedadRestController {

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<EnfermedadEntity> getEntities() {

        return enfermedadService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<EnfermedadDto> getDtos() throws Exception {
        return converter.toListDto(enfermedadService.listAll());
    }

}
