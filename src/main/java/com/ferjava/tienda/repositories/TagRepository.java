package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Long> {

    public Optional<TagEntity> findByNombre(String nombre);
}
