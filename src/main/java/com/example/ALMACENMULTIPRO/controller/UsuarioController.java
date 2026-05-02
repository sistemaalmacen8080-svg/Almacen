package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // LISTA
    @GetMapping("/Usuario")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "Usuario";
    }

    // FORM NUEVO
    @GetMapping("/NuevoUsu")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "NuevoUsu";
    }

    // GUARDAR
    @PostMapping("/guardarUsuario")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/Usuario";
    }

    // ELIMINAR
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(@PathVariable String id) {
        usuarioService.eliminar(id);
        return "redirect:/Usuario";
    }

    // EDITAR (vista)
    @GetMapping("/editarUsuario/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(id));
        return "NuevoUsu";
    }
}