package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.model.dto.PersonaDto;
import pe.gob.minsa.erh.model.dto.UserDto;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    UserDto globalUser;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("opcion", "Pacientes");
        model.addAttribute("user", globalUser);

        return "paciente/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("opcion", "Editar Paciente");
        model.addAttribute("user", globalUser);

        return "paciente/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("opcion", "Nuevo Paciente");
        model.addAttribute("user", globalUser);

        return "paciente/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PersonaDto dto, Model model) throws Exception {


        return "redirect:/paciente/";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        return "redirect:/paciente/";
    }

    @RequestMapping(value = "/enfermedad", method = RequestMethod.GET)
    public String listarEnfermedad(Model model) throws Exception {
        model.addAttribute("opcion", "Enfermedades");
        model.addAttribute("user", globalUser);

        return "paciente/enfermedad";
    }

    @RequestMapping(value = "/familiar", method = RequestMethod.GET)
    public String listarFamiliar(Model model) throws Exception {
        model.addAttribute("opcion", "Antecedentes Familiares");
        model.addAttribute("user", globalUser);

        return "paciente/familiar";
    }

    @RequestMapping(value = "/cuidador", method = RequestMethod.GET)
    public String listarCuidador(Model model) throws Exception {
        model.addAttribute("opcion", "Cuidadores");
        model.addAttribute("user", globalUser);

        return "paciente/cuidador";
    }

    @RequestMapping(value = "/discapacidad", method = RequestMethod.GET)
    public String listarDiscapacidad(Model model) throws Exception {
        model.addAttribute("opcion", "Discapacidades");
        model.addAttribute("user", globalUser);

        return "paciente/discapacidad";
    }

    @RequestMapping(value = "/enfermedad/editar", method = RequestMethod.GET)
    public String editarEnfermedad(Model model) throws Exception {
        model.addAttribute("opcion", "Editar Enfermedad");
        model.addAttribute("user", globalUser);

        return "paciente/formularioEnfermedad";
    }

    @RequestMapping(value = "/enfermedad/detalle", method = RequestMethod.GET)
    public String detalleEnfermedad(Model model) throws Exception {
        model.addAttribute("opcion", "Detalle Enfermedad");
        model.addAttribute("user", globalUser);

        return "paciente/detalleEnfermedad";
    }

    @RequestMapping(value = "/enfermedad/tratamiento", method = RequestMethod.GET)
    public String listarTratamiento(Model model) throws Exception {
        model.addAttribute("opcion", "Tratamiento Enfermedad");
        model.addAttribute("user", globalUser);

        return "paciente/tratamientoEnfermedad";
    }

    @RequestMapping(value = "/enfermedad/tratamiento/editar", method = RequestMethod.GET)
    public String editarEnfermedadTratamiento(Model model) throws Exception {
        model.addAttribute("opcion", "Editar Tratamiento");
        model.addAttribute("user", globalUser);

        return "paciente/formularioEnfermedadTratamiento";
    }

    @RequestMapping(value = "/familiar/editar", method = RequestMethod.GET)
    public String editarFamiliar(Model model) throws Exception {
        model.addAttribute("opcion", "Editar Antecedente Familiar");
        model.addAttribute("user", globalUser);

        return "paciente/formularioFamiliar";
    }

    @RequestMapping(value = "/familiar/detalle", method = RequestMethod.GET)
    public String detalleFamiliar(Model model) throws Exception {
        model.addAttribute("opcion", "Detalle Antecedente Familiar");
        model.addAttribute("user", globalUser);

        return "paciente/detalleFamiliar";
    }

    @RequestMapping(value = "/cuidador/editar", method = RequestMethod.GET)
    public String editarCuidador(Model model) throws Exception {
        model.addAttribute("opcion", "Editar Cuidador");
        model.addAttribute("user", globalUser);

        return "paciente/formularioCuidador";
    }

}
