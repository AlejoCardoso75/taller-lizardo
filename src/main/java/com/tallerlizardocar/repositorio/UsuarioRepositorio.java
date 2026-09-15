package com.tallerlizardocar.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tallerlizardocar.modelo.Usuario;

/**
 * Repositorio Spring Data JPA para la entidad Usuario.
 * Al extender JpaRepository, Spring genera automáticamente el CRUD
 * sin necesidad de escribir SQL manualmente.
 */
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     * Spring Data JPA genera la consulta a partir del nombre del método.
     *
     * @param nombreUsuario nombre de usuario a buscar
     * @return el usuario si existe, o vacío si no existe
     */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}