package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.gob.minsa.erh.converter.*;
import pe.gob.minsa.erh.model.dto.DiscapacidadDto;
import pe.gob.minsa.erh.model.dto.PacienteDto;
import pe.gob.minsa.erh.model.entity.DiscapacidadEntity;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/discapacidad")
public class DiscapacidadController {

    @Autowired
    private DiscapacidadService discapacidadService;
    @Autowired
    private DiscapacidadConverter discapacidadConverter;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private DocumentoService documentoService;
    @Autowired
    private DocumentoConverter documentoConverter;

    @Autowired
    private UbiDistritoService ubiDistritoService;
    @Autowired
    private UbiDistritoConverter ubiDistritoConverter;

    @Autowired
    private ParentescoService parentescoService;
    @Autowired
    private ParentescoConverter parentescoConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Discapacidad");
        model.addAttribute("opcion", "Mostrar");

        model.addAttribute("discapacidad", discapacidadConverter.toDto(discapacidadService.getById(id)));

        return "discapacidad/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Discapacidad");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("discapacidad", discapacidadConverter.toDto(discapacidadService.getById(id)));

//        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
//        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
//        model.addAttribute("generoEnum", GeneroEnum.values());
//        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "discapacidad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(@RequestParam(value = "pacienteId") Long pacienteId, Model model) throws Exception {
        model.addAttribute("titulo", "Discapacidad");
        model.addAttribute("opcion", "Nuevo");

        PacienteDto pacienteDto = pacienteConverter.toDto(pacienteService.getById(pacienteId));

        model.addAttribute("discapacidad", DiscapacidadDto.builder()
                .limitacionFuncional(EstadoEnum.INACTIVO)
                .inscritoConadis(EstadoEnum.INACTIVO)
                .paciente(pacienteDto)
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .build());

//        model.addAttribute("documentos", documentoConverter.toListDto(documentoService.listAll()));
//        model.addAttribute("distritos", ubiDistritoConverter.toListDto(ubiDistritoService.listAll()));
//        model.addAttribute("generoEnum", GeneroEnum.values());
//        model.addAttribute("parentescos", parentescoConverter.toListDto(parentescoService.listAll()));

        return "discapacidad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(DiscapacidadDto dto, Model model) throws Exception {

        model.addAttribute("titulo", "Discapacidad");
        model.addAttribute("opcion", "Búsqueda");

        DiscapacidadEntity newEntity = discapacidadService.saveOrUpdate(discapacidadConverter.toEntity(dto));

        if (newEntity != null) {
            model.addAttribute("paciente", discapacidadConverter.toDto(newEntity).getPaciente());
            model.addAttribute("discapacidades", discapacidadConverter.toListDto(discapacidadService.findDiscapacidadEntitiesByPaciente(newEntity.getPaciente())));
            model.addAttribute("success", "El registro de Discapacidad se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar el Discapacidad.");
        }

        return "discapacidad/listar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        DiscapacidadEntity entity = discapacidadService.getById(id);
        discapacidadService.delete(id);

        return String.format("redirect:/paciente/%s/discapacidad", discapacidadConverter.toDto(entity).getPaciente().getId());
    }

}
