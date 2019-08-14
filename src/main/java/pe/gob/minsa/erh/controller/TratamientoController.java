package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.EnfermedadConverter;
import pe.gob.minsa.erh.converter.TratamientoConverter;
import pe.gob.minsa.erh.model.entity.EnfermedadEntity;
import pe.gob.minsa.erh.service.EnfermedadService;
import pe.gob.minsa.erh.service.TratamientoService;

@Controller
@RequestMapping("/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientoService tratamientoService;
    @Autowired
    private TratamientoConverter tratamientoConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("tratamiento", tratamientoConverter.toDto(tratamientoService.getById(id)));
        return "tratamiento/mostrar";
    }

}
