package pe.gob.minsa.erh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.gob.minsa.erh.converter.AntecedenteFamiliarConverter;
import pe.gob.minsa.erh.converter.TratamientoConverter;
import pe.gob.minsa.erh.service.AntecedenteFamiliarService;
import pe.gob.minsa.erh.service.TratamientoService;

@Controller
@RequestMapping("/antecedentefamiliar")
public class AntecedenteFamiliarController {

    @Autowired
    private AntecedenteFamiliarService antecedenteFamiliarService;
    @Autowired
    private AntecedenteFamiliarConverter antecedenteFamiliarConverter;

    @RequestMapping(value = "/mostrar/{id}", method = RequestMethod.GET)
    public String mostrar(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Antecedente Familiar");
        model.addAttribute("opcion", "Mostrar");
        model.addAttribute("antecedenteFamiliar", antecedenteFamiliarConverter.toDto(antecedenteFamiliarService.getById(id)));
        return "antecedentefamiliar/mostrar";
    }

}
