package com.tallerlizardocar.repositorio;

import com.tallerlizardocar.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de acceso a datos para la entidad Producto.
 *
 * Al extender JpaRepository, Spring Data JPA genera automáticamente,
 * en tiempo de ejecución, la implementación de las operaciones CRUD
 * básicas (save, findAll, findById, deleteById, etc.) sin necesidad de
 * escribir una sola sentencia SQL ni una clase de implementación:
 * esta es la herramienta de almacenamiento de datos que exige la
 * evidencia, integrada mediante el framework Spring.
 *
 * JpaRepository<Producto, Integer>:
 *  - Producto: la entidad que administra este repositorio.
 *  - Integer: el tipo de dato de la llave primaria (id) de Producto.
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
