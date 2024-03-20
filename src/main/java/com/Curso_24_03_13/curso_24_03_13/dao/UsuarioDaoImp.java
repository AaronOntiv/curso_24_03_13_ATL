package com.Curso_24_03_13.curso_24_03_13.dao;

import com.Curso_24_03_13.curso_24_03_13.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;
    //hace la conexion con la base de dastos


    @Override
    public List<Usuario> getUsuarios() {
        String query="FROM Usuario";
        //Usuarios no es el nombre de la tabla, es el nombre de Clase

        return entityManager.createQuery(query).getResultList();
        //¿Como sabe a que columna hace referencia? en la clase Usuario se agregan notaciones.

    }


}
