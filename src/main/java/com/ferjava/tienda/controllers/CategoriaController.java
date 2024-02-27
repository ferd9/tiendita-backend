package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.UpdateCategoriaDTO;
import com.ferjava.tienda.dto.CreateCategoriaDTO;
import com.ferjava.tienda.models.CategoriaEntity;
import com.ferjava.tienda.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @PostMapping("/crear")
    public ResponseEntity<?> createCategoria(@RequestBody CreateCategoriaDTO createCategoriaDTO){
        CategoriaEntity categoriaEntity = new CategoriaEntity(createCategoriaDTO.getNombre(), createCategoriaDTO.getDescripcion());
        this.categoriaRepository.save(categoriaEntity);

        return ResponseEntity.ok(categoriaEntity);
    }

    @PostMapping("/crear-muchos")
    public ResponseEntity<?> createCategorias(@RequestBody List<CreateCategoriaDTO> createCategoriaDTO){

        List<CategoriaEntity> categoriaEntityList = new ArrayList<>();

        createCategoriaDTO.forEach(item -> {
            categoriaEntityList.add(new CategoriaEntity(item.getNombre(), item.getDescripcion()));
        });

        this.categoriaRepository.saveAll(categoriaEntityList);

        return ResponseEntity.ok(categoriaEntityList);
    }


    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarCategoria(@RequestBody UpdateCategoriaDTO updateCategoriaDTO){
        CategoriaEntity categoriaEntity = new CategoriaEntity(updateCategoriaDTO.getId(),
                                                              updateCategoriaDTO.getNombre(),
                                                              updateCategoriaDTO.getDescripcion());
        this.categoriaRepository.save(categoriaEntity);

        return ResponseEntity.ok(categoriaEntity);
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id){
        this.categoriaRepository.deleteById(id);
        Optional<CategoriaEntity> categoria = this.categoriaRepository.findById(id);

        if(!categoria.isPresent())
            return ResponseEntity.ok("No se pudo eliminar la categoria");
        return ResponseEntity.ok("categoria eliminada");
    }


    @GetMapping("/listar")
    public ResponseEntity<?> showAll(){
        return ResponseEntity.ok(this.categoriaRepository.findAll());
    }

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostraPorId(@PathVariable Long id){
        Optional<CategoriaEntity> categoria = this.categoriaRepository.findById(id);

        if(categoria.isEmpty())
            return ResponseEntity.ok("Categoria no encontrada");
        return ResponseEntity.ok(categoria);
    }

}
