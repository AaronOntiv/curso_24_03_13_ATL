package com.Curso_24_03_13.curso_24_03_13.controllers;

import com.Curso_24_03_13.curso_24_03_13.dao.UsuarioDao;
import com.Curso_24_03_13.curso_24_03_13.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired//Hace que la clase usuariodaoimplement crea un objeto y la guarda en esa variable.
    private UsuarioDao usuarioDao;
    //Esto es inyeccion de dependencias, ese objeto va a guardaarse en memoria, en cualquier parte del programa


    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario=new Usuario();
        usuario.setId(id);
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("Lucasmoy@correo");
        usuario.setTelefono("34343433");
        return usuario;
    }

    /*

    @RequestMapping(value = "usuario")
    public Usuario getUsuario(){
        Usuario usuario=new Usuario();
        usuario.setNombre("Lucas");
        usuario.setApellido("Moy");
        usuario.setEmail("Lucasmoy@correo");
        usuario.setTelefono("34343433");
        return usuario;
    } */


    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return  usuarioDao.getUsuarios();



    }
}
