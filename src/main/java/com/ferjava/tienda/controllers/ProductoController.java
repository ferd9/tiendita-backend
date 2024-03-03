package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateProductoDTO;
import com.ferjava.tienda.models.ProductoEntity;
import com.ferjava.tienda.models.ProveedorEntity;
import com.ferjava.tienda.repositories.ProductoRepository;
import com.ferjava.tienda.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;
    @Transactional
    @PostMapping("/crear")
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
                        productoEntity.getProveedores().addAll(
                         createProductoDTO.getProveedores()
                                 .stream()
                                 .map(prvdor -> {
                                     ProveedorEntity prvNormalizado = null;
                                     if(prvdor.getId() == null)
                                     {
                                         prvNormalizado  = this.proveedorRepository.save(prvdor);
                                     }else{
                                         Optional<ProveedorEntity> encontrado = this.proveedorRepository.findById(prvdor.getId());
                                         prvNormalizado = encontrado.orElseThrow();
                                     }

                                     prvNormalizado.getProductos().add(productoEntity);
                                     return prvNormalizado;
                                 }).collect(Collectors.toList())
                        );
                        productoEntity.setTags(createProductoDTO.getTags());

        this.productoRepository.save(productoEntity);
        return ResponseEntity.ok(productoEntity);
    }

    @PostMapping("/crear/muchos")
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

    @GetMapping("/listar")
    public ResponseEntity<?> listarProductos(){
        return ResponseEntity.ok(this.productoRepository.findAll());
    }

    @PutMapping("/actualizar")
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

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarProductoPorId(@PathVariable Long id){
        Optional<ProductoEntity> byId = this.productoRepository.findById(id);
        if(byId == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(byId);
    }

    @GetMapping("/buscar-por-nombre")
    public ResponseEntity<?> buscarProductoPorNombre(@RequestParam(name = "q") String nombre){
        List<ProductoEntity> listProductos = this.productoRepository.findByNombre(nombre);
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

    @GetMapping("/buscar-precio-mayor")
    public ResponseEntity<?> buscarProductoPrecioMayorQue(@RequestParam(name="q")Double precio){

        List<ProductoEntity> listProductos = this.productoRepository.findByprecioGreaterThan(precio);
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

    @GetMapping("/buscar-precio-menor")
    public ResponseEntity<?> buscarProductoPrecioMenorQue(@RequestParam(name="q") Double precio){
        List<ProductoEntity> listProductos = this.productoRepository.findByprecioLessThan(precio);
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

    @GetMapping("/buscar-por-precio")
    public ResponseEntity<?> buscarPorPrecio(@RequestParam(name = "q") Double precio){
        List<ProductoEntity> listProductos = this.productoRepository.findByprecio(precio);
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

    @GetMapping("/disponible")
    public ResponseEntity<?> listarProductosPorDiponibilidad(@RequestParam(name="q") Boolean disponibilidad){
        List<ProductoEntity> listProductos = new ArrayList<>(0);
        if(disponibilidad){
            listProductos = this.productoRepository.findBydisponibleTrue();
        }else{
            listProductos = this.productoRepository.findBydisponibleFalse();
        }
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

    @GetMapping("/buscar-fecha")
    public ResponseEntity<?> buscarPorFechaDeLanzamiento(@RequestParam(name = "q") LocalDate fechaDeLanzamiento){
        List<ProductoEntity> listProductos = this.productoRepository.findByfechaDeLanzamiento(fechaDeLanzamiento);
        if(listProductos == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Productos no encontrados.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(listProductos);
    }

}
