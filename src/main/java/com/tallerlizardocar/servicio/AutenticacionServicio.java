package com.tallerlizardocar.servicio;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tallerlizardocar.modelo.Usuario;
import com.tallerlizardocar.repositorio.UsuarioRepositorio;

/**
 * Contiene la lógica de negocio de registro e inicio de sesión.
 * El controlador solo expone las rutas HTTP; la validación real ocurre aquí.
 */
@Service
public class AutenticacionServicio {

    private final UsuarioRepositorio usuarioRepositorio;

    // BCrypt genera un hash distinto cada vez aunque la contraseña sea
    // igual, y permite comparar sin necesidad de descifrarlo.
    private final BCryptPasswordEncoder codificador = new BCryptPasswordEncoder();

    /** Inyección de dependencias por constructor. */
    public AutenticacionServicio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /**
     * Registra un nuevo usuario si el nombre de usuario no existe todavía.
     *
     * @param nombreUsuario nombre de usuario elegido
     * @param contrasena    contraseña en texto plano (se cifra antes de guardar)
     * @return true si el registro fue exitoso, false si el usuario ya existía
     */
    public boolean registrar(String nombreUsuario, String contrasena) {
        if (usuarioRepositorio.findByNombreUsuario(nombreUsuario).isPresent()) {
            // Ya existe un usuario con ese nombre: no se permite duplicar.
            return false;
        }
        String hash = codificador.encode(contrasena);
        usuarioRepositorio.save(new Usuario(nombreUsuario, hash));
        return true;
    }

    /**
     * Valida las credenciales de un usuario para el inicio de sesión.
     *
     * @param nombreUsuario nombre de usuario ingresado
     * @param contrasena    contraseña en texto plano ingresada
     * @return true si el usuario existe y la contraseña coincide con el hash guardado
     */
    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        Optional<Usuario> usuarioEncontrado = usuarioRepositorio.findByNombreUsuario(nombreUsuario);

        // Si no existe el usuario, la autenticación falla directamente.
        if (usuarioEncontrado.isEmpty()) {
            return false;
        }

        // matches() compara la contraseña en texto plano contra el hash guardado.
        return codificador.matches(contrasena, usuarioEncontrado.get().getContrasenaHash());
    }
}