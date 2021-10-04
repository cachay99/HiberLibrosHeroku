/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiberlibros.HiberLibros.services;

import com.hiberlibros.HiberLibros.entities.Autor;
import com.hiberlibros.HiberLibros.entities.Editorial;
import com.hiberlibros.HiberLibros.entities.Genero;
import com.hiberlibros.HiberLibros.entities.Libro;
import com.hiberlibros.HiberLibros.entities.Rol;
import com.hiberlibros.HiberLibros.entities.Usuario;
import com.hiberlibros.HiberLibros.entities.UsuarioSeguridad;
import com.hiberlibros.HiberLibros.interfaces.IGeneracionDatos;
import com.hiberlibros.HiberLibros.repositories.AutorRepository;
import com.hiberlibros.HiberLibros.repositories.ComentarioForoRepository;
import com.hiberlibros.HiberLibros.repositories.EditorialRepository;
import com.hiberlibros.HiberLibros.repositories.EventoRepository;
import com.hiberlibros.HiberLibros.repositories.ForoLibroRepository;
import com.hiberlibros.HiberLibros.repositories.GeneroRepository;
import com.hiberlibros.HiberLibros.repositories.IntercambioRepository;
import com.hiberlibros.HiberLibros.repositories.LibroRepository;
import com.hiberlibros.HiberLibros.repositories.PeticionRepository;
import com.hiberlibros.HiberLibros.repositories.PreferenciaRepository;
import com.hiberlibros.HiberLibros.repositories.RelatoRepository;
import com.hiberlibros.HiberLibros.repositories.RolRepository;
import com.hiberlibros.HiberLibros.repositories.UsuarioLibroRepository;
import com.hiberlibros.HiberLibros.repositories.UsuarioRepository;
import com.hiberlibros.HiberLibros.repositories.UsuarioSeguridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class GenerarDatos implements IGeneracionDatos {

    @Autowired
    private GeneroRepository repoGen;

    @Autowired
    private AutorRepository repoAutor;
    
    @Autowired
    private ComentarioForoRepository repoComentarioForo;
    
    @Autowired
    private EditorialRepository repoEditorial;
    
    @Autowired
    private EventoRepository repoEvento;
    
    @Autowired
    private ForoLibroRepository repoForoLibro;
    @Autowired
    private IntercambioRepository repoInter;
    
    @Autowired
    private LibroRepository repoLibro;
    
    @Autowired
    private PeticionRepository repoPeti;
    
    @Autowired
    private PreferenciaRepository repoPrefe;
    
    @Autowired
    private RelatoRepository repoRelato;
    @Autowired
    private RolRepository repoRol;
    
    @Autowired
    private UsuarioRepository repoUsuario;
    
    @Autowired
    private UsuarioLibroRepository repoUsuLibro;
    
    @Autowired
    private UsuarioSeguridadRepository repoUsuSegurity;
   
    
    @Autowired
    private PasswordEncoder encode;

    @Override
    public void generarDatos() {
        if (repoGen.findAll().isEmpty()) {
            repoGen.save(new Genero(1, "Clásicos", Boolean.FALSE, null, null, null));
            repoGen.save(new Genero(2, "Realismo", Boolean.FALSE, null, null, null));
            repoGen.save(new Genero(3, "Policiaca", Boolean.FALSE, null, null, null));
        }

        if (repoAutor.findAll().isEmpty()) {
            repoAutor.save(new Autor(1, "Fyodor", "Dostoyevsky", "Escritor ruso s.XIX", Boolean.FALSE, null));
            repoAutor.save(new Autor(2, "Julio", "Cortazar", "Escritor argentino s.XX", Boolean.FALSE, null));
            repoAutor.save(new Autor(3, "José", "Saramago", "Escritor portugués s.XX", Boolean.FALSE, null));
        }
        
        if(repoEditorial.findAll().isEmpty()){
            repoEditorial.save(new Editorial(1, "Anagrama", Boolean.FALSE));
            repoEditorial.save(new Editorial(2, "Alianza", Boolean.FALSE));
        }
        
        if(repoLibro.findAll().isEmpty()){
            repoLibro.save(new Libro(1, "isbn1", "Crimen y Castigo", "Español","https://images-na.ssl-images-amazon.com/images/I/71TCfoC27vL.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(1).get(), repoEditorial.findById(2).get(), repoGen.findById(1).get() ));
        }
        
        if(repoUsuario.findAll().isEmpty()){
            repoUsuario.save(new Usuario(1, "Pedro", "García", "C/Zaragoza", "Zaragoza", "pedro@correo.com", "666666666", null, null, null, null, Boolean.FALSE));
            repoUsuario.save(new Usuario(2, "María", "Gómez", "C/Zaragoza", "Zaragoza", "maria@correo.com", "666655566", null, null, null, null, Boolean.FALSE));
            repoUsuario.save(new Usuario(3, "Admin", "Admin", "C/Zaragoza", "Zaragoza", "admin@correo.com", "666644446", null, null, null, null, Boolean.FALSE));
        }
        if(repoUsuSegurity.findAll().isEmpty()){
            repoUsuSegurity.save(new UsuarioSeguridad(1, 1, "pedro@correo.com", encode.encode("1111"),null));
            repoUsuSegurity.save(new UsuarioSeguridad(2,2, "maria@correo.com", encode.encode("1111"),null));
            repoUsuSegurity.save(new UsuarioSeguridad(3, 3, "admin@correo.com", encode.encode("1111"),null));
            
        }
        
        if(repoRol.findAll().isEmpty()){
            repoRol.save(new Rol(1, "Usuario", new UsuarioSeguridad(1, 1, "pedro@correo.com", encode.encode("1111"),null)));
            repoRol.save(new Rol(2,"Usuario", new UsuarioSeguridad(2,2, "maria@correo.com", encode.encode("1111"),null)));
            repoRol.save(new Rol(3,"Administrador", new UsuarioSeguridad(3, 3, "admin@correo.com", encode.encode("1111"),null)));
        }
        
    }

}
