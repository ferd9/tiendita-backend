package com.ferjava.tienda.models;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public RoleEntity() {
    }
    public RoleEntity(ERole role) {
        this.role = role;
    }
    public RoleEntity(Long id, ERole role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
