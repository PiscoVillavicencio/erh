package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.PacienteConverter;
import pe.gob.minsa.erh.model.dto.PacienteDto;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pacientes")
public class PacienteRestController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<PacienteEntity> getEntities() {

        return pacienteService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<PacienteDto> getDtos() throws Exception {

        return converter.toListDto(pacienteService.listAll());
    }

}
