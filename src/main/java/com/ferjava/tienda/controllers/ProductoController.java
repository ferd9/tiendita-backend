package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateProductoDTO;
import com.ferjava.tienda.models.ProductoEntity;
import com.ferjava.tienda.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    public ResponseEntity<?> crearProducto(@RequestBody CreateProductoDTO createProductoDTO){
         ProductoEntity productoEntity = new ProductoEntity();
                        productoEntity.setNombre(createProductoDTO.getNombre());
                        productoEntity.setDescripcion(createProductoDTO.getDescripcion());
                        productoEntity.setPrecio(createProductoDTO.getPrecio());
                        productoEntity.setImgenUrl(createProductoDTO.getImgenUrl());
                        productoEntity.setMarca(createProductoDTO.getMarca());
                        productoEntity.setDisponible(createProductoDTO.getDisponible());
                        productoEntity.setFechaDeLanzamiento(createProductoDTO.getFechaDeLanzamiento());
                        productoEntity.setCategorias(createProductoDTO.getCategorias());
                        productoEntity.setProveedores(createProductoDTO.getProveedores());
                        productoEntity.setTags(createProductoDTO.getTags());

        this.productoRepository.save(productoEntity);
        return ResponseEntity.ok(productoEntity);
    }

    public ResponseEntity<?> crearProductos(@RequestBody List<CreateProductoDTO> createProductoDTOList){

        List<ProductoEntity> productoEntityList = new ArrayList<>();
        createProductoDTOList.forEach(createProductoDTO -> {
            ProductoEntity productoEntity = new ProductoEntity();
                            productoEntity.setNombre(createProductoDTO.getNombre());
                            productoEntity.setDescripcion(createProductoDTO.getDescripcion());
                            productoEntity.setPrecio(createProductoDTO.getPrecio());
                            productoEntity.setImgenUrl(createProductoDTO.getImgenUrl());
                            productoEntity.setMarca(createProductoDTO.getMarca());
                            productoEntity.setDisponible(createProductoDTO.getDisponible());
                            productoEntity.setFechaDeLanzamiento(createProductoDTO.getFechaDeLanzamiento());
                            productoEntity.setCategorias(createProductoDTO.getCategorias());
                            productoEntity.setProveedores(createProductoDTO.getProveedores());
                            productoEntity.setTags(createProductoDTO.getTags());
              productoEntityList.add(productoEntity);
        });
        return ResponseEntity.ok(productoEntityList);
    }

    public ResponseEntity<?> listarProductos(){
        return ResponseEntity.ok(this.productoRepository.findAll());
    }

    public ResponseEntity<?> actualizarProducto(@RequestBody CreateProductoDTO createProductoDTO){
        ProductoEntity productoEntity = new ProductoEntity();
                        productoEntity.setId(createProductoDTO.getId());
                        productoEntity.setNombre(createProductoDTO.getNombre());
                        productoEntity.setDescripcion(createProductoDTO.getDescripcion());
                        productoEntity.setPrecio(createProductoDTO.getPrecio());
                        productoEntity.setImgenUrl(createProductoDTO.getImgenUrl());
                        productoEntity.setMarca(createProductoDTO.getMarca());
                        productoEntity.setDisponible(createProductoDTO.getDisponible());
                        productoEntity.setFechaDeLanzamiento(createProductoDTO.getFechaDeLanzamiento());
                        productoEntity.setCategorias(createProductoDTO.getCategorias());
                        productoEntity.setProveedores(createProductoDTO.getProveedores());
                        productoEntity.setTags(createProductoDTO.getTags());

        this.productoRepository.save(productoEntity);
        return ResponseEntity.ok(productoEntity);
    }

    public ResponseEntity<?> buscarProductoPorId(@PathVariable Long id){

        return null;
    }

    public ResponseEntity<?> buscarProductoPorNombre(@RequestParam String nombre){
        return null;
    }

    public ResponseEntity<?> buscarProductoPrecioMayorQue(@RequestParam Double precio){
        return null;
    }

    public ResponseEntity<?> buscarProductoPrecioMenorQue(@RequestParam Double precio){
        return null;
    }

    public ResponseEntity<?> buscarPorPrecio(@RequestParam Double precio){
        return  null;
    }

    public ResponseEntity<?> listarProductosPorDiponibilidad(@RequestParam Boolean disponibilidad){
        return null;
    }

    public ResponseEntity<?> buscarPorFechaDeLanzamiento(@RequestParam LocalDate fechaDeLanzamiento){
        return null;
    }


}
