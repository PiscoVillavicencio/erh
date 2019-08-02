package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.DirectorConverter;
import pe.gob.minsa.erh.converter.IpressConverter;
import pe.gob.minsa.erh.model.dto.DirectorDto;
import pe.gob.minsa.erh.model.entity.DirectorEntity;
import pe.gob.minsa.erh.model.enums.PerfilEnum;
import pe.gob.minsa.erh.service.DirectorService;
import pe.gob.minsa.erh.service.IpressService;

@Controller
@RequestMapping("/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private IpressService ipressService;

    @Autowired
    private DirectorConverter directorConverter;

    @Autowired
    private IpressConverter ipressConverter;

    @RequestMapping(method = RequestMethod.GET)
    public String listar(Model model) {

        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("directores", directorConverter.toListDto(directorService.listAll()));
        return "director/listar";
    }

    @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Editar Director");
        model.addAttribute("director", directorConverter.toDto(directorService.getById(id)));
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "director/formulario";
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(Model model) {
        model.addAttribute("titulo", "MINSA-ERH");
        model.addAttribute("opcion", "Nuevo Director");
        model.addAttribute("director", DirectorDto.builder().perfil(PerfilEnum.DIRECTOR.getLabel()).build());
        model.addAttribute("ipresses", ipressConverter.toListDto(ipressService.listAll()));
        return "director/formulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(DirectorDto directorDto, Model model) {
        DirectorEntity directorEntity = directorService.saveOrUpdate(directorConverter.toEntity(directorDto));
        model.addAttribute("director", directorConverter.toDto(directorEntity));
        return "redirect:director/";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        directorService.delete(id);
        return "redirect:/director/listar";
    }

}
