package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.Cie10CategoriaConverter;
import pe.gob.minsa.erh.converter.UbiDistritoConverter;
import pe.gob.minsa.erh.model.dto.Cie10CategoriaDto;
import pe.gob.minsa.erh.model.dto.UbiDistritoDto;
import pe.gob.minsa.erh.model.entity.Cie10CategoriaEntity;
import pe.gob.minsa.erh.model.entity.UbiDistritoEntity;
import pe.gob.minsa.erh.service.Cie10CategoriaService;
import pe.gob.minsa.erh.service.UbiDistritoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cie10categorias")
public class Cie10CategoriaRestController {

    @Autowired
    private Cie10CategoriaService cie10CategoriaService;
    @Autowired
    private Cie10CategoriaConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<Cie10CategoriaEntity> getEntities() {

        return cie10CategoriaService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<Cie10CategoriaDto> getDtos() throws Exception {

        return converter.toListDto(cie10CategoriaService.listAll());
    }

}
