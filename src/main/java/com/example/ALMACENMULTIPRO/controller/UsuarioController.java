package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // LISTAR
    @GetMapping("/Usuario")
    public String listar(Model model) {
        model.addAttribute("usuarios", service.listar());
        return "Usuario";
    }

    // FORM NUEVO
    @GetMapping("/NuevoUsu")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "NuevoUsuario";
    }

    // GUARDAR
    @PostMapping("/guardarUsuario")
    public String guardar(@ModelAttribute Usuario usuario) {
        service.guardar(usuario);
        return "redirect:/Usuario";
    }

    // EDITAR (CARGA FORM)
    @GetMapping("/editarUsuario/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("usuario", service.buscar(id));
        return "EditarUsuario";
    }

    // ACTUALIZAR
    @PostMapping("/actualizarUsuario")
    public String actualizar(@ModelAttribute Usuario usuario) {
        service.actualizar(usuario);
        return "redirect:/Usuario";
    }

    // ELIMINAR
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/Usuario";
    }
}