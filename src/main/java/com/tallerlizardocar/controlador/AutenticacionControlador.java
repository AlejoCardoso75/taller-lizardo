package com.tallerlizardocar.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tallerlizardocar.dto.CredencialesDTO;
import com.tallerlizardocar.dto.RespuestaAutenticacionDTO;
import com.tallerlizardocar.servicio.AutenticacionServicio;

/**
 * Controlador REST del servicio web de registro e inicio de sesión.
 * @RestController hace que Spring convierta automáticamente los DTO
 * devueltos en JSON (no requiere vistas Thymeleaf).
 */
@RestController
@RequestMapping("/api/auth")
public class AutenticacionControlador {

    private final AutenticacionServicio autenticacionServicio;

    public AutenticacionControlador(AutenticacionServicio autenticacionServicio) {
        this.autenticacionServicio = autenticacionServicio;
    }

    /**
     * POST /api/auth/registro
     * Recibe { "nombreUsuario": "...", "contrasena": "..." } y crea el usuario.
     */
    @PostMapping("/registro")
    public ResponseEntity<RespuestaAutenticacionDTO> registrar(@RequestBody CredencialesDTO credenciales) {
        boolean creado = autenticacionServicio.registrar(
                credenciales.getNombreUsuario(),
                credenciales.getContrasena());

        if (creado) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RespuestaAutenticacionDTO(true, "Usuario registrado correctamente"));
        }
        // 409 CONFLICT: el nombre de usuario ya existe.
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new RespuestaAutenticacionDTO(false, "El nombre de usuario ya está en uso"));
    }

    /**
     * POST /api/auth/login
     * Recibe { "nombreUsuario": "...", "contrasena": "..." } y valida el acceso.
     * Este es el requisito puntual del caso: mensaje de autenticación
     * satisfactoria o error en la autenticación.
     */
    @PostMapping("/login")
    public ResponseEntity<RespuestaAutenticacionDTO> iniciarSesion(@RequestBody CredencialesDTO credenciales) {
        boolean valido = autenticacionServicio.validarCredenciales(
                credenciales.getNombreUsuario(),
                credenciales.getContrasena());

        if (valido) {
            return ResponseEntity.ok(new RespuestaAutenticacionDTO(true, "Autenticación satisfactoria"));
        }
        // 401 UNAUTHORIZED: usuario inexistente o contraseña incorrecta.
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new RespuestaAutenticacionDTO(false, "Error en la autenticación"));
    }
}