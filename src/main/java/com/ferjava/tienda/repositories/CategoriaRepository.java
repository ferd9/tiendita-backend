package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {
}
