package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DocumentoConverter;
import pe.gob.minsa.erh.model.dto.DocumentoDto;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.service.DocumentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/documentos")
public class DocumentoRestController {

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DocumentoEntity> getEntities() {

        return documentoService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DocumentoDto> getDtos() {
        return converter.toListDto(documentoService.listAll());
    }

}
