package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.RubroEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RubroRepository extends CrudRepository<RubroEntity, Long> {

    public Optional<RubroEntity> findByNombre(String nombre);
}
