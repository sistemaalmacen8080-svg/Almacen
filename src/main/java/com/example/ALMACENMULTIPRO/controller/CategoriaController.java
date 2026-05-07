package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Categoria;
import com.example.ALMACENMULTIPRO.service.CategoriaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(
            CategoriaService categoriaService) {

        this.categoriaService = categoriaService;
    }

    @GetMapping("/Categoria")
    public String listarCategorias(Model model) {

        model.addAttribute(
                "categorias",
                categoriaService.listarCategorias()
        );

        return "Categoria";
    }

    @GetMapping("/NuevaCat")
    public String nuevaCategoria(Model model) {

        model.addAttribute(
                "categoria",
                new Categoria()
        );

        return "NuevaCat";
    }

    @PostMapping("/guardarCategoria")
    public String guardarCategoria(
            @ModelAttribute Categoria categoria) {

        categoriaService.guardarCategoria(
                categoria
        );

        return "redirect:/Categoria";
    }

    @GetMapping("/editarCategoria/{id}")
    public String editarCategoria(
            @PathVariable String id,
            Model model) {

        model.addAttribute(
                "categoria",
                categoriaService.buscarCategoria(id)
        );

        return "EditarCategoria";
    }

    @PostMapping("/actualizarCategoria")
    public String actualizarCategoria(
            @ModelAttribute Categoria categoria) {

        categoriaService.actualizarCategoria(
                categoria
        );

        return "redirect:/Categoria";
    }

    @GetMapping("/eliminarCategoria/{id}")
    public String eliminarCategoria(
            @PathVariable String id) {

        categoriaService.eliminarCategoria(id);

        return "redirect:/Categoria";
    }
}