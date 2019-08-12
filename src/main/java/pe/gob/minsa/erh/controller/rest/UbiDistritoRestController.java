package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.UbiDistritoConverter;
import pe.gob.minsa.erh.model.dto.UbiDistritoDto;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;
import pe.gob.minsa.erh.service.UbiDistritoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/distritos")
public class UbiDistritoRestController {

    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private UbiDistritoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<UbiDistritoEntity> getEntities() {

        return ubiDistritoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<UbiDistritoDto> getDtos() throws Exception {

        return converter.toListDto(ubiDistritoService.listAll());
    }

}
