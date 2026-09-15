package com.tallerlizardocar.controlador;

import com.tallerlizardocar.modelo.Mantenimiento;
import com.tallerlizardocar.servicio.MantenimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoApiControlador {

    private final MantenimientoServicio mantenimientoServicio;

    @Autowired
    public MantenimientoApiControlador(MantenimientoServicio mantenimientoServicio) {
        this.mantenimientoServicio = mantenimientoServicio;
    }

    @GetMapping
    public List<Mantenimiento> listar(@RequestParam(required = false) String placa) {
        return mantenimientoServicio.listar(placa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> consultarPorId(@PathVariable Integer id) {
        Mantenimiento mantenimiento = mantenimientoServicio.buscarPorId(id);
        if (mantenimiento == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mantenimiento);
    }

    @PostMapping
    public ResponseEntity<Mantenimiento> crear(@RequestBody Mantenimiento mantenimiento) {
        mantenimiento.setId(null);
        mantenimientoServicio.guardar(mantenimiento);
        return ResponseEntity.status(201).body(mantenimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (mantenimientoServicio.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        mantenimientoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}