package com.ferjava.tienda.dto;

import javax.validation.constraints.NotBlank;

public class UpdateTagDTO {

    @NotBlank
    private Long id;

    @NotBlank
    private String nombre;


    public UpdateTagDTO() {
    }
    public UpdateTagDTO(Long id, String nombre) {
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
