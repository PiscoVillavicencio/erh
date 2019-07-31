package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.service.DirectorService;

@RequestMapping("/director")
@Controller
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de directores");
        model.addAttribute("directores", directorService.getAllDirectores());
        return "director/listar";
    }


}
