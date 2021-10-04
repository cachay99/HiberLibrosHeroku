package com.hiberlibros.HiberLibros.repositories;

import com.hiberlibros.HiberLibros.entities.UsuarioSeguridad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSeguridadRepository extends JpaRepository<UsuarioSeguridad, Integer> {

    // public Optional<UsuarioSeguridad> findByNombre(String username);
    public Optional<UsuarioSeguridad> findByIdUsuario(int idUsuario);

    public Optional<UsuarioSeguridad> findByMail(String mail);
}
