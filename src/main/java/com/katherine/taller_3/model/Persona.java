package com.katherine.taller_3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String tipo;

    @OneToOne(mappedBy = "idPersona", cascade = CascadeType.REMOVE)
    private Usuario usuario;

    @OneToOne(mappedBy = "personaId", cascade = CascadeType.REMOVE)
    private Bibliotecario bibliotecario;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
