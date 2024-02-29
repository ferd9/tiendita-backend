package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {

    public List<ProductoEntity> findByNombre(String nombre);
    public List<ProductoEntity> findByprecioGreaterThan(Double precio);

    public List<ProductoEntity> findByprecioLessThan(Double precio);

    public List<ProductoEntity> findByprecio(Double precio);

    public List<ProductoEntity> findBydisponibleTrue();

    public List<ProductoEntity> findBydisponibleFalse();

    public List<ProductoEntity> findByfechaDeLanzamiento(LocalDate fechaDeLanzamiento);
}
