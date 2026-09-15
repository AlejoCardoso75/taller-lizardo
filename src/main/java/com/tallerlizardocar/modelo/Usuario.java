package com.tallerlizardocar.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

/**
 * Entidad JPA que representa un usuario del sistema Taller Lizardo Car.
 * Se mapea a la tabla "usuarios" en MySQL.
 * La contraseña NUNCA se guarda en texto plano: se almacena su hash
 * generado con BCrypt (ver AutenticacionServicio).
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_usuario"))
public class Usuario {

    /** Identificador autogenerado por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de usuario único usado para iniciar sesión. */
    @Column(name = "nombre_usuario", nullable = false, unique = true, length = 50)
    private String nombreUsuario;

    /** Hash BCrypt de la contraseña (nunca la contraseña original). */
    @Column(name = "contrasena_hash", nullable = false)
    private String contrasenaHash;

    /** Constructor vacío requerido por JPA. */
    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasenaHash) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
}