package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.EnfermedadConverter;
import pe.gob.minsa.erh.converter.IpressConverter;
import pe.gob.minsa.erh.converter.PacienteConverter;
import pe.gob.minsa.erh.converter.PersonaConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.dto.PacienteDto;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.model.enums.EstadoEnum;
import pe.gob.minsa.erh.model.enums.GeneroEnum;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.EnfermedadService;
import pe.gob.minsa.erh.service.IpressService;
import pe.gob.minsa.erh.service.PacienteService;
import pe.gob.minsa.erh.service.PersonaService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteConverter pacienteConverter;

    @Autowired
    private IpressService ipressService;
    @Autowired
    private IpressConverter ipressConverter;

    @Autowired
    private PersonaService personaService;
    @Autowired
    private PersonaConverter personaConverter;

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Búsqueda");
        model.addAttribute("pacientes", pacienteConverter.toListDto(pacienteService.listAll()));
        return "paciente/listar";
    }

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("paciente", pacienteConverter.toDto(pacienteService.getById(id)));
        return "paciente/mostrar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Editar");
        model.addAttribute("paciente", pacienteConverter.toDto(pacienteService.getById(id)));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "paciente/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Paciente");
        model.addAttribute("opcion", "Nuevo");
        model.addAttribute("paciente", PacienteDto.builder()
                .persona(PersonaDto.builder().genero(GeneroEnum.OTRO).build())
                .estado(EstadoEnum.ACTIVO)
                .fecRegistro(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .fecModificacion(new SimpleDateFormat("dd-MM-yyyy").format(new Date()))
                .perfil(PerfilEnum.DIRECTOR)
                .build());
        model.addAttribute("personas", personaConverter.toListDto(personaService.listAll()));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "paciente/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PacienteDto dto, Model model) throws Exception {
        PacienteEntity newEntity = pacienteService.saveOrUpdate(pacienteConverter.toEntity(dto));
        model.addAttribute("newEntity", pacienteConverter.toDto(newEntity));
        return "redirect:/paciente/";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) {
        pacienteService.delete(id);
        return "redirect:/paciente/";
    }

    @RequestMapping(value = "/{id}/enfermedad", method = RequestMethod.GET)
    public String listarEnfermedades(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);
        model.addAttribute("enfermedades", enfermedadConverter.toListDto(enfermedadService.findEnfermedadEntitiesByPaciente(entity)));
        return "enfermedad/listar";
    }

    @RequestMapping(value = "/{id}/antecedentefamiliar", method = RequestMethod.GET)
    public String listarAntecedentesFamiliares(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Búsqueda");

        PacienteEntity entity = pacienteService.getById(id);
        model.addAttribute("paciente", pacienteConverter.toDto(entity));
        return "antecedentefamiliar/listar";
    }

}
