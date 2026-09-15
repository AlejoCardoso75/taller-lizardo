package com.tallerlizardocar.controlador;

import com.tallerlizardocar.dto.UsuarioResumenDTO;
import com.tallerlizardocar.modelo.Usuario;
import com.tallerlizardocar.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioApiControlador {

    private final UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UsuarioApiControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping
    public List<UsuarioResumenDTO> listar() {
        return usuarioRepositorio.findAll().stream()
                .map(usuario -> new UsuarioResumenDTO(usuario.getId(), usuario.getNombreUsuario()))
                .toList();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (usuarioRepositorio.findById(id).isEmpty()) return ResponseEntity.notFound().build();
        usuarioRepositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}