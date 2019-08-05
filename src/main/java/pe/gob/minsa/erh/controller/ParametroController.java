package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.DirectorConverter;
import pe.gob.minsa.erh.converter.DocumentoConverter;
import pe.gob.minsa.erh.converter.IpressConverter;
import pe.gob.minsa.erh.converter.ParentescoConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.dto.DocumentoDto;
import pe.gob.minsa.erh.model.dto.ParentescoDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.DocumentoEntity;
import pe.gob.minsa.erh.model.entity.ParentescoEntity;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.DirectorService;
import pe.gob.minsa.erh.service.DocumentoService;
import pe.gob.minsa.erh.service.IpressService;
import pe.gob.minsa.erh.service.ParentescoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/parametro")
public class ParametroController {

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private DocumentoConverter documentoConverter;
    @Autowired
    private ParentescoConverter parentescoConverter;


    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Parametros");
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));
        return "parametro/listar";
    }

    @RequestMapping(value = "documento/editar/{id}", method = RequestMethod.GET)
    public String documentoEditar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Editar Documento");
        model.addAttribute("documento", documentoConverter.toDto(documentoService.getById(id)));
        return "parametro/formularioDocumento";
    }

    @RequestMapping(value = "parentesco/editar/{id}", method = RequestMethod.GET)
    public String parentescoEditar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Editar Parentesco");
        model.addAttribute("parentesco", parentescoConverter.toDto(parentescoService.getById(id)));
        return "parametro/formularioParentesco";
    }

    @RequestMapping(value = "documento/nuevo", method = RequestMethod.GET)
    public String documentoNuevo(Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Nuevo Documento");
        model.addAttribute("documento", DocumentoDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        return "parametro/formularioDocumento";
    }

    @RequestMapping(value = "parentesco/nuevo", method = RequestMethod.GET)
    public String parentescoNuevo(Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Nuevo Parentesco");
        model.addAttribute("parentesco", ParentescoDto.builder()
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        return "parametro/formularioParentesco";
    }

    @RequestMapping(value = "/documento", method = RequestMethod.POST)
    public String documentoSaveOrUpdate(DocumentoDto dto, Model model) throws Exception {
        DocumentoEntity newEntity = documentoService.saveOrUpdate(documentoConverter.toEntity(dto));
        model.addAttribute("newEntity", documentoConverter.toDto(newEntity));
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "/parentesco", method = RequestMethod.POST)
    public String parentescoSaveOrUpdate(ParentescoDto dto, Model model) throws Exception {
        ParentescoEntity newEntity = parentescoService.saveOrUpdate(parentescoConverter.toEntity(dto));
        model.addAttribute("newEntity", parentescoConverter.toDto(newEntity));
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "documento/eliminar/{id}")
    public String documentoDelete(@PathVariable(value = "id") Long id) {
        documentoService.delete(id);
        return "redirect:/parametro/";
    }

    @RequestMapping(value = "parentesco/eliminar/{id}")
    public String parentescoDelete(@PathVariable(value = "id") Long id) {
        parentescoService.delete(id);
        return "redirect:/parametro/";
    }

}
