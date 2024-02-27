package com.ferjava.tienda.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RubroEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "proveedores_rubro",
            joinColumns = @JoinColumn(name = "proveedor_id"),
            inverseJoinColumns = @JoinColumn(name = "rubro_id"))
    private Set<RubroEntity> rubros;


    public ProveedorEntity() {
    }

    public ProveedorEntity(String nombre, String direccion, String ruc, String email, String telefono, Set<RubroEntity> rubros) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ruc = ruc;
        this.email = email;
        this.telefono = telefono;
        this.rubros = rubros;
    }

    public ProveedorEntity(Long id, String nombre, String direccion, String ruc, String email, String telefono, Set<RubroEntity> rubros) {
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


