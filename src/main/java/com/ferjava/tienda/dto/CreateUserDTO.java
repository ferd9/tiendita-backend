package com.ferjava.tienda.dto;

import com.ferjava.tienda.models.RoleEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public class CreateUserDTO {

    public CreateUserDTO() {
    }


    public CreateUserDTO(String nombre, String apellido, String email, String username, String telefono, String password, Set<RoleEntity> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = username;
        this.telefono = telefono;
        this.password = password;
        this.roles = roles;
    }

    @NotBlank
    @Column(name="nombre")
    private String nombre;
    @NotBlank
    @Column(name="apellido")
    private String apellido;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String username;
    private String telefono;

    @NotBlank
    private String password;

    private Set<RoleEntity> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
