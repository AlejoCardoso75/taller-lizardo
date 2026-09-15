package com.tallerlizardocar.dto;

/**
 * DTO que representa el cuerpo JSON enviado tanto para registro como
 * para login: { "nombreUsuario": "...", "contrasena": "..." }
 */
public class CredencialesDTO {

    private String nombreUsuario;
    private String contrasena;

    public CredencialesDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}