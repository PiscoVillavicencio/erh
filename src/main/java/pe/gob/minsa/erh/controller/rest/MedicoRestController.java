package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.EnfermedadConverter;
import pe.gob.minsa.erh.converter.MedicoConverter;
import pe.gob.minsa.erh.model.dto.EnfermedadDto;
import pe.gob.minsa.erh.model.dto.MedicoDto;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.model.entity.MedicoEntity;
import pe.gob.minsa.erh.service.EnfermedadService;
import pe.gob.minsa.erh.service.MedicoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoRestController {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<MedicoEntity> getEntities() {

        return medicoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<MedicoDto> getDtos() throws Exception {
        return converter.toListDto(medicoService.listAll());
    }

}
