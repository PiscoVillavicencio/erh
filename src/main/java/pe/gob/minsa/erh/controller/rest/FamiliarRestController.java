package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.AntecedenteFamiliarConverter;
import pe.gob.minsa.erh.model.dto.AntecedenteFamiliarDto;
import pe.gob.minsa.erh.model.entity.AntecedenteFamiliarEntity;
import pe.gob.minsa.erh.service.AntecedenteFamiliarService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/antecedentesfamiliares")
public class AntecedenteFamiliarRestController {

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;
    @Autowired
    private AntecedenteFamiliarConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<AntecedenteFamiliarEntity> getEntities() {

        return antecedenteFamiliarService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<AntecedenteFamiliarDto> getDtos() throws Exception {

        return converter.toListDto(antecedenteFamiliarService.listAll());
    }

}
