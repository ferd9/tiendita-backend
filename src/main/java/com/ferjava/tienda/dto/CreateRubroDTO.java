package com.ferjava.tienda.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateRubroDTO {

    @NotBlank
    @Size(max = 120)
    private String nombre;


    public CreateRubroDTO() {
    }

    public CreateRubroDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
