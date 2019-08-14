package pe.gob.minsa.erh.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.minsa.erh.converter.DocumentoConverter;
import pe.gob.minsa.erh.converter.DocumentoEnfermedadConverter;
import pe.gob.minsa.erh.model.dto.DocumentoDto;
import pe.gob.minsa.erh.model.dto.DocumentoEnfermedadDto;
import pe.gob.minsa.erh.model.entity.DocumentoEnfermedadEntity;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.service.DocumentoEnfermedadService;
import pe.gob.minsa.erh.service.DocumentoService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/documentosenfermedades")
public class DocumentoEnfermedadRestController {

    @Autowired
    private DocumentoEnfermedadService documentoEnfermedadService;
    @Autowired
    private DocumentoEnfermedadConverter converter;

    @GetMapping(value = "/entities", produces = "application/json")
    public List<DocumentoEnfermedadEntity> getEntities() {

        return documentoEnfermedadService.listAll();
    }

    @GetMapping(value = "/dtos", produces = "application/json")
    public List<DocumentoEnfermedadDto> getDtos() throws Exception {
        return converter.toListDto(documentoEnfermedadService.listAll());
    }

}
