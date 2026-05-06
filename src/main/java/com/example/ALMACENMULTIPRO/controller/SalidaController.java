package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Salida;
import com.example.ALMACENMULTIPRO.service.SalidaService;
import com.example.ALMACENMULTIPRO.service.ProductoService;
import com.example.ALMACENMULTIPRO.service.UsuarioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SalidaController {

    private final SalidaService service;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;

    public SalidaController(SalidaService service,
                            UsuarioService usuarioService,
                            ProductoService productoService) {
        this.service = service;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    @GetMapping("/Gestionsalidas")
    public String listar(Model model) {
        model.addAttribute("salidas", service.listar());
        return "Gestionsalidas";
    }

    @GetMapping("/Salida")
    public String nuevo(Model model) {
        model.addAttribute("salida", new Salida());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("productos", productoService.listar());
        return "Salida";
    }

    @PostMapping("/guardarSalida")
    public String guardar(@ModelAttribute Salida salida) {
        service.guardar(salida);
        return "redirect:/Gestionsalidas";
    }

    @GetMapping("/verSalida/{id}")
    public String ver(@PathVariable String id, Model model) {
        model.addAttribute("salida", service.buscar(id));
        return "VermasSalidas";
    }

    @GetMapping("/eliminarSalida/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/Gestionsalidas"; // 🔥 corregido
    }
}