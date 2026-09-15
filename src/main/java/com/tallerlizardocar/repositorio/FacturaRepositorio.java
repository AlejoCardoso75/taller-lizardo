package com.tallerlizardocar.repositorio;

import com.tallerlizardocar.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}