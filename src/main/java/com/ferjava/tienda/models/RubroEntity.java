package com.ferjava.tienda.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="rubros", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre", name = "uniqueNameConstraint")})
public class RubroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    private String nombre;

    public RubroEntity() {
    }

    public RubroEntity(String nombre) {
        this.nombre = nombre;
    }

    public RubroEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
