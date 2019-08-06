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
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    UserDto globalUser;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) throws Exception {
        model.addAttribute("opcion", "Médicos Tratante");
        model.addAttribute("user", globalUser);

        return "medico/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("opcion", "Editar Médico Tratante");
        model.addAttribute("user", globalUser);

        return "medico/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) throws Exception {
        model.addAttribute("opcion", "Nuevo Médico Tratante");
        model.addAttribute("user", globalUser);

        return "medico/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(PersonaDto dto, Model model) throws Exception {


        return "redirect:/medico/";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id) throws Exception {

        return "redirect:/medico/";
    }

}
