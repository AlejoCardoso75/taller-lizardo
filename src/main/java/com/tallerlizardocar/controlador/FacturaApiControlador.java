package com.tallerlizardocar.controlador;

import com.tallerlizardocar.dto.ReporteFacturacionDTO;
import com.tallerlizardocar.modelo.Factura;
import com.tallerlizardocar.servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaApiControlador {

    private final FacturaServicio facturaServicio;

    @Autowired
    public FacturaApiControlador(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    @GetMapping
    public List<Factura> listar() {
        return facturaServicio.listarTodas();
    }

    @GetMapping("/reporte")
    public ReporteFacturacionDTO reporte() {
        return facturaServicio.calcularReporte();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> consultarPorId(@PathVariable Integer id) {
        Factura factura = facturaServicio.buscarPorId(id);
        if (factura == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(factura);
    }

    @PostMapping
    public ResponseEntity<Factura> crear(@RequestBody Factura factura) {
        factura.setId(null);
        facturaServicio.guardar(factura);
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (facturaServicio.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        facturaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}