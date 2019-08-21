package pe.gob.minsa.erh.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model, Authentication auth) {
        model.addAttribute("titulo", "Dashboard");
        model.addAttribute("opcion", "Bienvenido " + StringUtils.capitalize(auth.getName()));
        model.addAttribute("username", StringUtils.capitalize(auth.getName()));

        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            model.addAttribute("userrol", grantedAuthority.getAuthority());
        }

        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error,
                        Model model, Principal principal, RedirectAttributes flash) {

        if(principal != null) {
            flash.addFlashAttribute("info", "Usuario logueado en el sistema.");
            return "redirect:/";
        }

        if(error != null) {
            model.addAttribute("error", "Error de ingreso al sistema, usuario o contraseña incorrecta.");
        }

        return "login";
    }


}
