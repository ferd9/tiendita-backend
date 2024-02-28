package com.ferjava.tienda.dto;

import com.ferjava.tienda.models.RubroEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class CreateProveedorDTO {

    private Long id;

    @NotBlank
    @Size(max = 120)
    private String nombre;


    @Size(max = 255)
    private String direccion;

    @NotBlank
    @Size(max = 15)
    private String ruc;

    @Email
    @Size(max = 120)
    private String email;

    @Size(max = 15)
    private String telefono;

    private Set<RubroEntity> rubros;

    public CreateProveedorDTO() {
    }

    public CreateProveedorDTO(String nombre, String direccion, String ruc, String email, String telefono, Set<RubroEntity> rubros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.rubros = rubros;
    }

    public CreateProveedorDTO(Long id, String nombre, String direccion, String ruc, String email, String telefono, Set<RubroEntity> rubros) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.rubros = rubros;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<RubroEntity> getRubros() {
        return rubros;
    }

    public void setRubros(Set<RubroEntity> rubros) {
        this.rubros = rubros;
    }
}
