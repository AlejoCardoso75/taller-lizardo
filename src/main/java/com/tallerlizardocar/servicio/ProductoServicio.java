package com.tallerlizardocar.servicio;

import com.tallerlizardocar.modelo.Producto;
import com.tallerlizardocar.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio del módulo de Inventario.
 *
 * Contiene la lógica de negocio y actúa como intermediario entre el
 * controlador (capa web) y el repositorio (capa de datos). Separar esta
 * lógica en su propia clase permite reutilizarla desde distintos
 * controladores (por ejemplo, uno web y otro tipo API REST) sin
 * duplicar código.
 */
@Service
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    /**
     * Spring inyecta automáticamente la implementación del repositorio
     * a través del constructor (inyección de dependencias).
     */
    @Autowired
    public ProductoServicio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }

    /**
     * Devuelve el listado completo de productos registrados.
     */
    public List<Producto> listarTodos() {
        return productoRepositorio.findAll();
    }

    /**
     * Busca un producto por su id. Devuelve null si no existe.
     */
    public Producto buscarPorId(Integer id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    /**
     * Guarda un producto: si no tiene id, Spring Data JPA lo inserta
     * como uno nuevo; si ya tiene id, actualiza el registro existente.
     */
    public void guardar(Producto producto) {
        productoRepositorio.save(producto);
    }

    /**
     * Elimina un producto a partir de su id.
     */
    public void eliminar(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
