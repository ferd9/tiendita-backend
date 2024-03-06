package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.ProductoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {


    //public Page<ProductoEntity> findByIdNotIn(List<Integer> ids, Pageable pageable);
    public List<ProductoEntity> findByNombre(String nombre);
    public List<ProductoEntity> findByprecioGreaterThan(Double precio);

    public List<ProductoEntity> findByprecioLessThan(Double precio);

    public List<ProductoEntity> findByprecio(Double precio);

    public List<ProductoEntity> findBydisponibleTrue();

    public List<ProductoEntity> findBydisponibleFalse();

    public List<ProductoEntity> findByfechaDeLanzamiento(LocalDate fechaDeLanzamiento);
}
