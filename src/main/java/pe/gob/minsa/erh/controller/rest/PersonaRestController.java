package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DirectorConverter;
import pe.gob.minsa.erh.converter.PersonaConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.service.DirectorService;
import pe.gob.minsa.erh.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/personas")
public class PersonaRestController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<PersonaEntity> getEntities() {

        return personaService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<PersonaDto> getDtos() throws Exception {

        return converter.toListDto(personaService.listAll());
    }

}
