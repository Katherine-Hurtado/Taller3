package com.katherine.taller_3.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_persona")
    private Persona idPersona;

//    private String rol;

    @OneToOne(mappedBy = "idUsuario", cascade = CascadeType.REMOVE)
    private Prestamo prestamo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

//    public String getRol() {
//        return rol;
//    }
//
//    public void setRol(String rol) {
//        this.rol = rol;
//    }
}
