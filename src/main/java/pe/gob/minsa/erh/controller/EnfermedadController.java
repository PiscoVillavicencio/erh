package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.EnfermedadConverter;
import pe.gob.minsa.erh.converter.TratamientoConverter;
import pe.gob.minsa.erh.model.dto.EnfermedadDto;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.model.entity.PacienteEntity;
import pe.gob.minsa.erh.service.EnfermedadService;
import pe.gob.minsa.erh.service.TratamientoService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Secured({"ROLE_MASTER", "ROLE_DIRECTOR", "ROLE_MEDICO", "ROLE_PACIENTE"})
@RequestMapping("/enfermedad")
public class EnfermedadController {

    @Autowired
    private EnfermedadService enfermedadService;
    @Autowired
    private EnfermedadConverter enfermedadConverter;

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter tratamientoConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Mostrar");

        model.addAttribute("enfermedad", enfermedadConverter.toDto(enfermedadService.getById(id)));

        return "enfermedad/mostrar";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Editar");

        model.addAttribute("enfermedad", enfermedadConverter.toDto(enfermedadService.getById(id)));

        return "enfermedad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("titulo", "Enfermedad");
        model.addAttribute("opcion", "Nuevo");

        model.addAttribute("enfermedad", EnfermedadDto.builder()

                .build());

        return "enfermedad/formulario";
    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(EnfermedadDto dto, Model model) throws Exception {

        List<EnfermedadDto> entities = new ArrayList<>();
        EnfermedadEntity newEntity = enfermedadService.saveOrUpdate(enfermedadConverter.toEntity(dto));

        if(newEntity != null){
            entities.add(enfermedadConverter.toDto(newEntity));
        }

        if (entities.size() > 0) {
            model.addAttribute("paciente", entities.get(0).getPaciente());
            model.addAttribute("enfermedades", entities);
            model.addAttribute("success", "El registro de enfermedad se realizó con éxito.");
        } else {
            model.addAttribute("warning", "Ocurrió un error al registrar la enfermedad.");
        }

        return "enfermedad/listar";

    }

    @Secured({"ROLE_MASTER", "ROLE_MEDICO"})
    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        EnfermedadEntity entity = enfermedadService.getById(id);
        enfermedadService.delete(id);

        return String.format("redirect:/%s/enfermedad", enfermedadConverter.toDto(entity).getPaciente().getId());
    }

    @RequestMapping(value = "/{id}/tratamiento", method = RequestMethod.GET)
    public String listarTratamiento(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Búsqueda");

        EnfermedadEntity entity = enfermedadService.getById(id);
        model.addAttribute("tratamientos", tratamientoConverter.toListDto(tratamientoService.findTratamientoEntitiesByEnfermedad(entity)));
        return "tratamiento/listar";
    }

}
