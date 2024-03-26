package com.Curso_24_03_13.curso_24_03_13.controllers;

import com.Curso_24_03_13.curso_24_03_13.dao.UsuarioDao;
import com.Curso_24_03_13.curso_24_03_13.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired//Hace que la clase usuariodaoimplement crea un objeto y la guarda en esa variable.
    private UsuarioDao usuarioDao;
    //Esto es inyeccion de dependencias, ese objeto va a guardaarse en memoria, en cualquier parte del programa



    /*Por defecto cuando no tiene nada
    * esto esta como;   @RequestMapping(value = "api/usuarios/{id}",method=RequestMethod.GET) */
    @RequestMapping(value = "api/usuarios/{id}")
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


    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return  usuarioDao.getUsuarios();



    }

    /*Va a ser lo mismo que get usuario solo que vamos a camibar el metodo
    *
    * OJO: si ponemos que es un metodo DELETE no significa que automaticamente estara eliminando, eso
    * dependera completamente de nosotros
    *
    * Lo que nos dice la notacion de requestMapping es que si entramos por la URL:api/usuarios y por el
    * metodo DELETE nos mandara a esta funcion.*/
    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable long id){
        usuarioDao.eliminar(id);

    }
}
