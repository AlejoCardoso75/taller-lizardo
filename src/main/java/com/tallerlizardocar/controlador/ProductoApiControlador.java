package com.tallerlizardocar.controlador;

import com.tallerlizardocar.modelo.Producto;
import com.tallerlizardocar.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador tipo API REST del módulo de Inventario.
 *
 * A diferencia de ProductoControlador (que devuelve vistas HTML con
 * Thymeleaf), esta clase usa @RestController: cada método serializa
 * automáticamente su respuesta a JSON, sin necesidad de una vista.
 * Reutiliza la misma capa de servicio, sin duplicar lógica de negocio.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoApiControlador {

    private final ProductoServicio productoServicio;

    @Autowired
    public ProductoApiControlador(ProductoServicio productoServicio) {
        this.productoServicio = productoServicio;
    }

    /** GET /api/productos -> lista todos los productos en JSON. */
    @GetMapping
    public List<Producto> listar() {
        return productoServicio.listarTodos();
    }

    /** GET /api/productos/{id} -> un producto en JSON, o 404 si no existe. */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> consultarPorId(@PathVariable Integer id) {
        Producto producto = productoServicio.buscarPorId(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    /** POST /api/productos -> crea un producto a partir del JSON recibido. */
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        producto.setId(null); // aseguramos que sea un INSERT, no un UPDATE
        productoServicio.guardar(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    /** PUT /api/productos/{id} -> actualiza un producto existente. */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        if (productoServicio.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        productoServicio.guardar(producto);
        return ResponseEntity.ok(producto);
    }

    /** DELETE /api/productos/{id} -> elimina un producto. */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (productoServicio.buscarPorId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        productoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}