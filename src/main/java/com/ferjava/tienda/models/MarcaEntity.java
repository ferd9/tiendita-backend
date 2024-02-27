package com.ferjava.tienda.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="marcas")
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    private String nombre;

    @Size(max = 255)
    private String descipcion;

    public MarcaEntity() {
    }

    public MarcaEntity(String nombre, String descipcion) {
        this.nombre = nombre;
        this.descipcion = descipcion;
    }

    public MarcaEntity(Long id, String nombre, String descipcion) {
        this.id = id;
        this.nombre = nombre;
        this.descipcion = descipcion;
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

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }
}
