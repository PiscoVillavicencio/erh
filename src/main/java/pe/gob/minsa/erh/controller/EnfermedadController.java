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

    @RequestMapping(value = "/{id}/tratamiento", method = RequestMethod.GET)
    public String listarTratamiento(@PathVariable(value = "id") Long id, Model model) throws Exception {
        model.addAttribute("titulo", "Tratamiento");
        model.addAttribute("opcion", "Búsqueda");

        EnfermedadEntity entity = enfermedadService.getById(id);
        model.addAttribute("tratamientos", tratamientoConverter.toListDto(tratamientoService.findTratamientoEntitiesByEnfermedad(entity)));
        return "tratamiento/listar";
    }

}
