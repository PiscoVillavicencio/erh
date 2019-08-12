package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.Cie10BloqueConverter;
import pe.gob.minsa.erh.converter.Cie10CategoriaConverter;
import pe.gob.minsa.erh.model.dto.Cie10BloqueDto;
import pe.gob.minsa.erh.model.dto.Cie10CategoriaDto;
import pe.gob.minsa.erh.model.entity.Cie10BloqueEntity;
import pe.gob.minsa.erh.model.entity.Cie10CategoriaEntity;
import pe.gob.minsa.erh.service.Cie10BloqueService;
import pe.gob.minsa.erh.service.Cie10CategoriaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cie10bloques")
public class Cie10BloqueRestController {

    @Autowired
    private Cie10BloqueService cie10BloqueService;
    @Autowired
    private Cie10BloqueConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<Cie10BloqueEntity> getEntities() {

        return cie10BloqueService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<Cie10BloqueDto> getDtos() throws Exception {

        return converter.toListDto(cie10BloqueService.listAll());
    }

}
