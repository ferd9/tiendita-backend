package com.ferjava.tienda.dto;

import javax.validation.constraints.NotBlank;

public class UpdateCategoriaDTO {

    @NotBlank
    private Long id;
    @NotBlank
    private String nombre;

    private String descripcion;

    public UpdateCategoriaDTO() {
    }


    public UpdateCategoriaDTO(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public UpdateCategoriaDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


