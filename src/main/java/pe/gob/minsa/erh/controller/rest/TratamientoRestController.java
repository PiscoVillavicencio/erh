package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.MedicoConverter;
import pe.gob.minsa.erh.converter.TratamientoConverter;
import pe.gob.minsa.erh.model.dto.MedicoDto;
import pe.gob.minsa.erh.model.dto.TratamientoDto;
import pe.gob.minsa.erh.model.entity.MedicoEntity;
import pe.gob.minsa.erh.model.entity.TratamientoEntity;
import pe.gob.minsa.erh.service.MedicoService;
import pe.gob.minsa.erh.service.TratamientoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tratamientos")
public class TratamientoRestController {

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<TratamientoEntity> getEntities() {

        return tratamientoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<TratamientoDto> getDtos() throws Exception {
        return converter.toListDto(tratamientoService.listAll());
    }

}
