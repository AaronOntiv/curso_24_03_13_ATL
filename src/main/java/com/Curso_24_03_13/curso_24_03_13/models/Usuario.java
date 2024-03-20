package com.Curso_24_03_13.curso_24_03_13.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Getter @Setter @Column(name= "id")
    @Id
    private Long id;

    @Getter @Setter @Column(name= "nombre")
    private String nombre;

    @Getter @Setter @Column(name= "apellido")
    private String apellido;

    @Getter @Setter @Column(name= "email")
    private String email;

    @Getter @Setter @Column(name= "telefono")
    private String telefono;

    @Getter @Setter @Column(name= "password")
    private String password;




}
