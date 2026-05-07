package com.example.ALMACENMULTIPRO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio() {

        return "Login";
    }

    @GetMapping("/Main")
    public String main() {
        return "Main";
    }

    @GetMapping("/Contacto")
    public String contacto() {
        return "Contacto";
    }


    @GetMapping("/Metrica")
    public String metrica() {
        return "Metrica";
    }

    @GetMapping("/Publicidad")
    public String publicidad() {
        return "Publicidad";
    }
}