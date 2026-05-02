package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.service.UsuarioService;
import com.example.ALMACENMULTIPRO.service.ProductoService;
import com.example.ALMACENMULTIPRO.model.Ingreso;
import com.example.ALMACENMULTIPRO.service.IngresoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngresoController {

    private final IngresoService service;
    private final UsuarioService usuarioService;
    private final ProductoService productoService;

    public IngresoController(
            IngresoService service,
            UsuarioService usuarioService,
            ProductoService productoService) {

        this.service = service;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    @GetMapping("/GestionIngreso")
    public String lista(Model model) {
        model.addAttribute("ingresos", service.listar());
        return "GestionIngreso";
    }

    @GetMapping("/ingresos")
    public String nuevo(Model model) {
        model.addAttribute("ingreso", new Ingreso());
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("productos", productoService.listar());
        return "ingresos";
    }

    @PostMapping("/guardarIngreso")
    public String guardar(@ModelAttribute Ingreso ingreso) {
        service.guardar(ingreso);
        return "redirect:/GestionIngreso";
    }

    @GetMapping("/verIngreso/{id}")
    public String ver(@PathVariable String id, Model model) {
        model.addAttribute("ingreso", service.buscar(id));
        return "VermasIngreso";
    }
    @GetMapping("/eliminarIngreso/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/GestionIngreso";
    }
}