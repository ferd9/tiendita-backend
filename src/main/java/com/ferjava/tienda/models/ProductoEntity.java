package com.ferjava.tienda.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    private String nombre;

    @Size(max = 500)
    private String descripcion;


    private Double precio;

    @Size(max = 120)
    private String imgenUrl;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = MarcaEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "producto_marca",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "marca_id"))
    private Set<MarcaEntity> marca;

    private Boolean disponible;

    private LocalDate fechaDeLanzamiento;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = CategoriaEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "producto_categorias",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<CategoriaEntity> categorias;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = ProveedorEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "producto_proveedores",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id"))
    private Set<ProveedorEntity> proveedores;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = TagEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "producto_tags",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<TagEntity> tags;


    public ProductoEntity() {
    }

    public ProductoEntity(String nombre, String descripcion, Double precio, String imgenUrl, Set<MarcaEntity> marca, Boolean disponible, LocalDate fechaDeLanzamiento, Set<CategoriaEntity> categorias, Set<ProveedorEntity> proveedores, Set<TagEntity> tags) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imgenUrl = imgenUrl;
        this.marca = marca;
        this.disponible = disponible;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.categorias = categorias;
        this.proveedores = proveedores;
        this.tags = tags;
    }

    public ProductoEntity(Long id, String nombre, String descripcion, Double precio, String imgenUrl, Set<MarcaEntity> marca, Boolean disponible, LocalDate fechaDeLanzamiento, Set<CategoriaEntity> categorias, Set<ProveedorEntity> proveedores, Set<TagEntity> tags) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imgenUrl = imgenUrl;
        this.marca = marca;
        this.disponible = disponible;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.categorias = categorias;
        this.proveedores = proveedores;
        this.tags = tags;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImgenUrl() {
        return imgenUrl;
    }

    public void setImgenUrl(String imgenUrl) {
        this.imgenUrl = imgenUrl;
    }

    public Set<MarcaEntity> getMarca() {
        return marca;
    }

    public void setMarca(Set<MarcaEntity> marca) {
        this.marca = marca;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Set<CategoriaEntity> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<CategoriaEntity> categorias) {
        this.categorias = categorias;
    }

    public Set<ProveedorEntity> getProveedores() {
        return proveedores;
    }

    public void setProveedores(Set<ProveedorEntity> proveedores) {
        this.proveedores = proveedores;
    }

    public Set<TagEntity> getTags() {
        return tags;
    }

    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }
}
