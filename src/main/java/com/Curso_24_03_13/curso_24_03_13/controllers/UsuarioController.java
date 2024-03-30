package com.Curso_24_03_13.curso_24_03_13.controllers;

import com.Curso_24_03_13.curso_24_03_13.dao.UsuarioDao;
import com.Curso_24_03_13.curso_24_03_13.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value="api/usuarios",method=RequestMethod.POST)
    public void reqistrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registrar(usuario);
    }











    /*
    //RequestBody convierte el json que recibe a un usuario automanticamente
    @RequestMapping(value = "api/usuarios",method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
          usuarioDao.registrar(usuario);
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
