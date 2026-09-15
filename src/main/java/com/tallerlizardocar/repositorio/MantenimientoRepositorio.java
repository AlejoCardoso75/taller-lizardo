package com.tallerlizardocar.repositorio;

import com.tallerlizardocar.modelo.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientoRepositorio extends JpaRepository<Mantenimiento, Integer> {

    /** Busca mantenimientos cuya placa contenga el texto indicado (sin distinguir mayúsculas). */
    List<Mantenimiento> findByPlacaContainingIgnoreCase(String placa);
}