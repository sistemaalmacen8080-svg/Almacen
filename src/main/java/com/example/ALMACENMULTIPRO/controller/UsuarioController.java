package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Usuario;
import com.example.ALMACENMULTIPRO.service.UsuarioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(
            UsuarioService usuarioService) {

        this.usuarioService = usuarioService;
    }

    @GetMapping("/Usuario")
    public String listarUsuarios(Model model) {

        model.addAttribute(
                "usuarios",
                usuarioService.listarUsuarios()
        );

        return "Usuario";
    }

    @GetMapping("/NuevoUsu")
    public String nuevoUsuario(Model model) {

        model.addAttribute(
                "usuario",
                new Usuario()
        );

        return "NuevoUsu";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(
            @ModelAttribute Usuario usuario) {

        usuarioService.guardarUsuario(
                usuario
        );

        return "redirect:/Usuario";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(
            @PathVariable String id,
            Model model) {

        model.addAttribute(
                "usuario",
                usuarioService.buscarUsuario(id)
        );

        return "EditarUsuario";
    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(
            @ModelAttribute Usuario usuario) {

        usuarioService.actualizarUsuario(
                usuario
        );

        return "redirect:/Usuario";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(
            @PathVariable String id) {

        usuarioService.eliminarUsuario(id);

        return "redirect:/Usuario";
    }
}