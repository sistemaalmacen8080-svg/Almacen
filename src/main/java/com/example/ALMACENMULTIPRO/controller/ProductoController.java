package com.example.ALMACENMULTIPRO.controller;

import com.example.ALMACENMULTIPRO.model.Producto;
import com.example.ALMACENMULTIPRO.service.ProductoService;
import com.example.ALMACENMULTIPRO.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoController {

    @Autowired
    private ProductoService service;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/Producto")
    public String formularioProducto(Model model) {

        model.addAttribute("producto", new Producto());
        model.addAttribute("categorias", categoriaService.listarCategorias());

        return "Producto";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute Producto producto) {

        service.guardar(producto);

        return "redirect:/Gestion";
    }
    @GetMapping("/Gestion")
    public String listarProductos(Model model) {
        model.addAttribute("productos", service.listar());
        return "Gestion";
    }
    @GetMapping("/eliminarProducto/{id}")
    public String eliminar(@PathVariable String id) {
        service.eliminar(id);
        return "redirect:/Gestion";
    }
    @GetMapping("/editarProducto/{id}")
    public String editar(@PathVariable String id, Model model) {
        model.addAttribute("producto", service.buscarPorId(id));
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "Producto";
    }
}