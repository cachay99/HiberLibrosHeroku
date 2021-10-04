/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hiberlibros.HiberLibros.services;

import com.hiberlibros.HiberLibros.entities.Autor;
import com.hiberlibros.HiberLibros.entities.Editorial;
import com.hiberlibros.HiberLibros.entities.Genero;
import com.hiberlibros.HiberLibros.entities.Intercambio;
import com.hiberlibros.HiberLibros.entities.Libro;
import com.hiberlibros.HiberLibros.entities.Peticion;
import com.hiberlibros.HiberLibros.entities.Relato;
import com.hiberlibros.HiberLibros.entities.Rol;
import com.hiberlibros.HiberLibros.entities.Usuario;
import com.hiberlibros.HiberLibros.entities.UsuarioLibro;
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
import java.time.Instant;
import java.util.Date;
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
            repoLibro.save(new Libro(2, "isbn2", "El adolescente", "Español","https://www.librosyliteratura.es/wp-content/uploads/2012/08/el_adolescente.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(1).get(), repoEditorial.findById(2).get(), repoGen.findById(1).get() ));
            repoLibro.save(new Libro(3, "isbn3", "Rayuela", "Español","https://images-eu.ssl-images-amazon.com/images/I/51TTNGsFeAL._SX342_SY445_QL70_ML2_.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(2).get(), repoEditorial.findById(1).get(), repoGen.findById(2).get() ));
            repoLibro.save(new Libro(4, "isbn4", "Cronopios y fama", "Español","https://images-na.ssl-images-amazon.com/images/I/91KRWuErG8S.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(2).get(), repoEditorial.findById(1).get(), repoGen.findById(2).get() ));
            repoLibro.save(new Libro(5, "isbn5", "Estudio sobre la ceguera", "Español","http://emprendedor.faduaemex.org.mx/wp-content/uploads/2018/11/ensayo-sobre-la-ceguera-jos-saramago-1-638.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(3).get(), repoEditorial.findById(1).get(), repoGen.findById(1).get() ));
            repoLibro.save(new Libro(6, "isbn6", "La caverna", "Español","http://2.bp.blogspot.com/-L5UxO1f3eQI/VPMPuL9RicI/AAAAAAAAESc/SEmlbSAFza4/s1600/portada-caverna.jpg", 5.0, 1, Boolean.FALSE,
                    repoAutor.findById(3).get(), repoEditorial.findById(2).get(), repoGen.findById(2).get() ));
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
        if(repoUsuLibro.findAll().isEmpty()){
            repoUsuLibro.save(new UsuarioLibro(1, "Bien", "Libre", "Tengo", Boolean.FALSE, repoUsuario.findById(1).get(), repoLibro.findById(1).get()) );
            repoUsuLibro.save(new UsuarioLibro(2, "Mal", "Libre", "Tengo", Boolean.FALSE, repoUsuario.findById(1).get(), repoLibro.findById(3).get()) );
            repoUsuLibro.save(new UsuarioLibro(3, "Bien", "Libre", "Tengo", Boolean.FALSE, repoUsuario.findById(2).get(), repoLibro.findById(5).get()) );
            repoUsuLibro.save(new UsuarioLibro(4, "Excelente", "Libre", "Tengo", Boolean.FALSE, repoUsuario.findById(2).get(), repoLibro.findById(2).get()) );        
        }
        
        if(repoPeti.findAll().isEmpty()){
            repoPeti.save(new Peticion(1, repoUsuLibro.findById(1).get(),repoUsuario.findById(2).get(), null, Boolean.TRUE ));
            repoPeti.save(new Peticion(2, repoUsuLibro.findById(2).get(),repoUsuario.findById(2).get(), Boolean.TRUE, Boolean.FALSE ));
        }
        
        if(repoInter.findAll().isEmpty()){
            repoInter.save(new Intercambio(1, Date.from(Instant.now()), null,repoUsuLibro.findById(2).get(), repoUsuLibro.findById(3).get()));
        }
        
        if(repoRelato.findAll().isEmpty()){
            
        }
        
    }

}
