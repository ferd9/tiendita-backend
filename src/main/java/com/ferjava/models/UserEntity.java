package com.ferjava.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="users")
public class UserEntity {

    public UserEntity() {
    }


    public UserEntity(String nombre, String apellido, String email, String telefono, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    public UserEntity(Long id, String nombre, String apellido, String email, String telefono, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;

    @Email
    @NotBlank
    @Size(max = 120)
    @Column(name="email")
    private String email;

    @NotBlank
    @Size(max = 40)
    @Column(name="username")
    private String username;

    @Column(name="telefono")
    private String telefono;

    @NotBlank
    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(nombre, userEntity.nombre) && Objects.equals(apellido, userEntity.apellido) && Objects.equals(email, userEntity.email) && Objects.equals(telefono, userEntity.telefono) && Objects.equals(password, userEntity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, email, telefono, password);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
