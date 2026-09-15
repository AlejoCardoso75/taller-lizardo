package com.tallerlizardocar.servicio;

import com.tallerlizardocar.modelo.Mantenimiento;
import com.tallerlizardocar.repositorio.MantenimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MantenimientoServicio {

    private final MantenimientoRepositorio mantenimientoRepositorio;

    @Autowired
    public MantenimientoServicio(MantenimientoRepositorio mantenimientoRepositorio) {
        this.mantenimientoRepositorio = mantenimientoRepositorio;
    }

    public List<Mantenimiento> listar(String placa) {
        if (placa == null || placa.isBlank()) {
            return mantenimientoRepositorio.findAll();
        }
        return mantenimientoRepositorio.findByPlacaContainingIgnoreCase(placa);
    }

    public Mantenimiento buscarPorId(Integer id) {
        return mantenimientoRepositorio.findById(id).orElse(null);
    }

    public void guardar(Mantenimiento mantenimiento) {
        mantenimientoRepositorio.save(mantenimiento);
    }

    public void eliminar(Integer id) {
        mantenimientoRepositorio.deleteById(id);
    }
}