package com.ferjava.tienda.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="tags", uniqueConstraints = {
        @UniqueConstraint(columnNames = "nombre", name = "uniqueNameConstraint")})
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Size(max = 120)
    @Column(name = "nombre", unique = true, nullable = false)
    private String nombre;


    public TagEntity() {
    }

    public TagEntity(String nombre) {
        this.nombre = nombre;
    }

    public TagEntity(Long id, String nombre) {
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
