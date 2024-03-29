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

    @Override
    public void eliminar(long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);

    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);

    }

    @Override
    public boolean verificarCredenciales(Usuario usuario){
        String query="FROM Usuario WHERE email= :email AND password= :password ";
        //Esto evita la inyeccion SQL
        List<Usuario> lista=entityManager.createQuery(query)
                .setParameter("email",usuario.getEmail())
                .setParameter("password",usuario.getPassword())
                .getResultList();
        return !lista.isEmpty();



    }




}
