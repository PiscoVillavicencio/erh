package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.DistritoConverter;
import pe.gob.minsa.erh.converter.DocumentoConverter;
import pe.gob.minsa.erh.converter.PersonaConverter;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.entity.PersonaEntity;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.NacionalidadEnum;
import pe.gob.minsa.erh.service.DistritoService;
import pe.gob.minsa.erh.service.DocumentoService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private DistritoService distritoService;
    @Autowired
    private DistritoConverter distritoConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Persona");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("personas", personaConverter.toListDto(personaService.listAll()));
        return "persona/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Persona");
        model.addAttribute("opcion", "Editar");
        model.addAttribute("persona", personaConverter.toDto(personaService.getById(id)));
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("nacionalidadEnum", NacionalidadEnum.values());
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", distritoConverter.toListDto(distritoService.listAll()));
        return "persona/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Persona");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("persona", PersonaDto.builder()
                .condicion(EstadoEnum.ACTIVO)
                .genero(GeneroEnum.OTRO)
                .documento(documentoConverter.toDto(documentoService.getById(1L)))
                .origenNacionalidad(NacionalidadEnum.NACIONAL)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());
        model.addAttribute("generoEnum", GeneroEnum.values());
        model.addAttribute("nacionalidadEnum", NacionalidadEnum.values());
        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
        model.addAttribute("distritos", distritoConverter.toListDto(distritoService.listAll()));
        return "persona/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PersonaDto dto, Model model) throws Exception {
        PersonaEntity newEntity = personaService.saveOrUpdate(personaConverter.toEntity(dto));
        model.addAttribute("newEntity", personaConverter.toDto(newEntity));
        return "redirect:/persona/";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {
        personaService.delete(id);
        return "redirect:/persona/";
    }


}
