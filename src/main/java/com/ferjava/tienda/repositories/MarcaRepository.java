package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.MarcaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MarcaRepository extends CrudRepository<MarcaEntity, Long> {

    Optional<MarcaEntity> findByNombre(String nombre);
}
