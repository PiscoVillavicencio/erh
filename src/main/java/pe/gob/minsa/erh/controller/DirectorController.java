package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.DirectorConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.service.DirectorService;

import java.util.List;

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
        model.addAttribute("directores", converter.toListDto(directorService.listAll()));
        return "director/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Editar Director");
        model.addAttribute("director", converter.toDto(directorService.getById(id)));
        return "director/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Nuevo Director");
        model.addAttribute("director", DirectorDto.builder().build());
        return "director/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(DirectorDto directorDto, Model model) {
        DirectorEntity directorEntity = directorService.saveOrUpdate(converter.toEntity(directorDto));
        model.addAttribute("director", converter.toDto(directorEntity));
        return "redirect:director/listar/";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        directorService.delete(id);
        return "redirect:/director/listar";
    }

}
