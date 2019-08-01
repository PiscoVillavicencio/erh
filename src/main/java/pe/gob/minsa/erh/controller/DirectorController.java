package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.DirectorConverter;
import pe.gob.minsa.erh.service.DirectorService;

@Controller
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private DirectorConverter converter;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {

        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("directores", converter.toListDto(directorService.getAllDirectores()));
        return "director/listar";
    }

    @RequestMapping(value="/editar/{id}")
    public String editar(@PathVariable(value="id") Long id, Model model){
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("director", converter.toDto(directorService.getDirectorById(id)));
        return "director/formulario";
    }


}
