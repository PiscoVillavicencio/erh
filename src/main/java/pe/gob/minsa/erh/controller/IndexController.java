package pe.gob.minsa.erh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.model.dto.UserDto;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("user", UserDto.builder().build());

        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String index(UserDto user, Model model) {
        model.addAttribute("titulo", "MINSA-ERH");

        if(user.getUser().equalsIgnoreCase("master")){
            model.addAttribute("opcion", "Dashboard Master");
            model.addAttribute("user", user);
            return "indexMaster";
        }else if (user.getUser().equalsIgnoreCase("director")){
            model.addAttribute("opcion", "Dashboard Director");
            model.addAttribute("user", user);
            return "indexDirector";
        }else if (user.getUser().equalsIgnoreCase("administrador")){
            model.addAttribute("opcion", "Dashboard Administrador");
            model.addAttribute("user", user);
            return "indexAdministrador";
        }else if (user.getUser().equalsIgnoreCase("medico")){
            model.addAttribute("opcion", "Dashboard Médico");
            model.addAttribute("user", user);
            return "indexMedico";
        }else if (user.getUser().equalsIgnoreCase("paciente")){
            model.addAttribute("opcion", "Dashboard Paciente");
            model.addAttribute("user", user);
            return "indexPaciente";
        }

        return "redirect:/";
    }

}
