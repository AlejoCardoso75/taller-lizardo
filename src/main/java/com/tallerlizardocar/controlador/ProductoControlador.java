package com.tallerlizardocar.controlador;

import com.tallerlizardocar.modelo.Producto;
import com.tallerlizardocar.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador web del módulo de Inventario.
 *
 * Cada método está anotado con @GetMapping o @PostMapping, lo que
 * reemplaza el switch manual sobre un parámetro "accion" que se usaba
 * en la versión con Servlets puros (evidencia AA2-EV02): aquí es el
 * propio framework el que enruta cada combinación de URL + método HTTP
 * hacia el método correspondiente.
 */
@Controller
@RequestMapping("/productos")
public class ProductoControlador {

    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    /**
     * GET /productos -> lista todos los productos en listar.html.
     */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productoServicio.listarTodos());
        return "listar";
    }

    /**
     * GET /productos/nuevo -> muestra el formulario vacío.
     */
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    /**
     * GET /productos/editar/{id} -> muestra el formulario precargado
     * con los datos del producto indicado.
     */
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Producto producto = productoServicio.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "formulario";
    }

    /**
     * POST /productos/guardar -> recibe los datos del formulario HTML
     * (@ModelAttribute los asocia automáticamente a un objeto Producto)
     * e inserta o actualiza el registro, según si trae id o no.
     */
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        productoServicio.guardar(producto);
        return "redirect:/productos";
    }

    /**
     * GET /productos/eliminar/{id} -> elimina el producto y regresa al listado.
     */
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        productoServicio.eliminar(id);
        return "redirect:/productos";
    }
}
