package com.hiberlibros.HiberLibros.repositories;

import com.hiberlibros.HiberLibros.entities.Rol;
import com.hiberlibros.HiberLibros.entities.UsuarioSeguridad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    //public long deleteByIdUsuarioSeguridad(Integer idUsuarioSeguridad);
    public Optional<Rol> findByIdUsuario(UsuarioSeguridad us);
}
