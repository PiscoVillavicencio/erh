package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.EnlaceInteresConverter;
import pe.gob.minsa.erh.converter.IpressConverter;
import pe.gob.minsa.erh.model.dto.EnlaceInteresDto;
import pe.gob.minsa.erh.model.dto.IpressDto;
import pe.gob.minsa.erh.model.entity.EnlaceInteresEntity;
import pe.gob.minsa.erh.service.EnlaceInteresService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/enlaceintereses")
public class EnlaceInteresRestController {

    @Autowired
    private EnlaceInteresService enlaceInteresService;
    @Autowired
    private EnlaceInteresConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<EnlaceInteresEntity> getEntities() {

        return enlaceInteresService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<EnlaceInteresDto> getDtos() throws Exception {

        return converter.toListDto(enlaceInteresService.listAll());
    }

}
