package com.tallerlizardocar.servicio;

import com.tallerlizardocar.dto.ReporteFacturacionDTO;
import com.tallerlizardocar.modelo.Factura;
import com.tallerlizardocar.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServicio {

    private final FacturaRepositorio facturaRepositorio;

    @Autowired
    public FacturaServicio(FacturaRepositorio facturaRepositorio) {
        this.facturaRepositorio = facturaRepositorio;
    }

    public List<Factura> listarTodas() {
        return facturaRepositorio.findAll();
    }

    public Factura buscarPorId(Integer id) {
        return facturaRepositorio.findById(id).orElse(null);
    }

    public void guardar(Factura factura) {
        facturaRepositorio.save(factura);
    }

    public void eliminar(Integer id) {
        facturaRepositorio.deleteById(id);
    }

    public ReporteFacturacionDTO calcularReporte() {
        List<Factura> facturas = facturaRepositorio.findAll();
        double total = facturas.stream().mapToDouble(Factura::getValorTotal).sum();
        double promedio = facturas.isEmpty() ? 0 : total / facturas.size();
        return new ReporteFacturacionDTO(facturas.size(), total, promedio);
    }
}