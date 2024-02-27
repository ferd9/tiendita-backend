package com.ferjava.tienda.dto;

import javax.validation.constraints.NotBlank;

public class CreateTagDTO {

    @NotBlank
    private String nombre;

    public CreateTagDTO() {
    }

    public CreateTagDTO(String name) {
        this.nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
