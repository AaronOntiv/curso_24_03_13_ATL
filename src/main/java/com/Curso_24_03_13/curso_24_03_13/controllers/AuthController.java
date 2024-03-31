package com.Curso_24_03_13.curso_24_03_13.controllers;

import com.Curso_24_03_13.curso_24_03_13.dao.UsuarioDao;
import com.Curso_24_03_13.curso_24_03_13.models.Usuario;
import com.Curso_24_03_13.curso_24_03_13.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    //En la clase JWTUtil tiene la notacion @Component
    //Sirve para compartirlo en todos los lugares y nos permite ocupar la notacion
    //de @Value para tomar los valores de properties.
    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogeado= usuarioDao.obtenerUsuarioporCredenciales(usuario);

        if(usuarioLogeado!=null){

           String tokenJwt= jwtUtil.create(String.valueOf(usuarioLogeado.getId()), String.valueOf(usuarioLogeado.getEmail()));
            return tokenJwt;
        }
        return "FAIL";


    }

}
