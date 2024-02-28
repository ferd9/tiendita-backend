package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.ProveedorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProveedorRepository extends CrudRepository<ProveedorEntity, Long> {

    public Optional<ProveedorEntity> findByNombre(String nombre);
    public Optional<ProveedorEntity> findByRuc(String ruc);
    public Optional<ProveedorEntity> findByEmail(String email);
}
