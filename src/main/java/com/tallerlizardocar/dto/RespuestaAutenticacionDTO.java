package com.tallerlizardocar.dto;

/**
 * DTO de respuesta estándar para las rutas de registro y login.
 * "exitoso" permite al frontend distinguir el resultado sin depender
 * del texto exacto del mensaje.
 */
public class RespuestaAutenticacionDTO {

    private boolean exitoso;
    private String mensaje;

    public RespuestaAutenticacionDTO(boolean exitoso, String mensaje) {
        this.exitoso = exitoso;
        this.mensaje = mensaje;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public String getMensaje() {
        return mensaje;
    }
}