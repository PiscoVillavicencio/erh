package pe.gob.minsa.erh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("opcion", "Bienvenido");
        return "index";
    }

    @GetMapping("/login")
    public String index(Model model) {





        return "login";
    }



}
