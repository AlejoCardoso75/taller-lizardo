package com.tallerlizardocar.dto;

public class UsuarioResumenDTO {

    private Long id;
    private String nombreUsuario;

    public UsuarioResumenDTO(Long id, String nombreUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
    }

    public Long getId() { return id; }
    public String getNombreUsuario() { return nombreUsuario; }
}