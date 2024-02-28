package com.ferjava.tienda.controllers;


import com.ferjava.tienda.dto.CreateMarcaDTO;
import com.ferjava.tienda.models.MarcaEntity;
import com.ferjava.tienda.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;
    @PostMapping("/crear")
    public ResponseEntity<?> crearMarca(@RequestBody CreateMarcaDTO createMarcaDTO){

        MarcaEntity rubro = new MarcaEntity(createMarcaDTO.getNombre(), createMarcaDTO.getDescripcion());
        this.marcaRepository.save(rubro);
        return ResponseEntity.ok(rubro);
    }

    @PostMapping("/crear/muchos")
    public ResponseEntity <?> crearMarcas(@RequestBody List<CreateMarcaDTO> listCreateMarcaDTO){

        List<MarcaEntity> listMarca = new ArrayList<>();
        listCreateMarcaDTO.forEach(marca -> {
            listMarca.add(new MarcaEntity(marca.getNombre(), marca.getDescripcion()));
        });

        this.marcaRepository.saveAll(listMarca);
        return ResponseEntity.ok(listMarca);
    }

    @PutMapping("/actualizar")
    public ResponseEntity <?> actualizarMarca(@RequestBody CreateMarcaDTO updateMarcaDTO){
        MarcaEntity tag = new MarcaEntity(updateMarcaDTO.getId(),updateMarcaDTO.getNombre(),updateMarcaDTO.getDescripcion());
        this.marcaRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/listar")
    public ResponseEntity <?> listarMarcas(){
        return ResponseEntity.ok(this.marcaRepository.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity <?> buscarMarcaPorId(@PathVariable long id){
        Optional<MarcaEntity> optionalRubro = this.marcaRepository.findById(id);
        if(optionalRubro.isPresent())
        {
            return ResponseEntity.ok(optionalRubro.get());
        }
        return ResponseEntity.ok("marca inexistente");
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity <?> actualizarMarcaPorNombre(@PathVariable String nombre){
        Optional<MarcaEntity> marcaEntity = this.marcaRepository.findByNombre(nombre);

        if(marcaEntity.isPresent())
        {
            return ResponseEntity.ok(marcaEntity.get());
        }
        return ResponseEntity.ok("marca inexistente");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity <?> eliminarMarca(@PathVariable long id){
        this.marcaRepository.deleteById(id);
        Optional<MarcaEntity> marca = this.marcaRepository.findById(id);

        if(marca.isPresent()){
            ResponseEntity.ok("El marca fue eliminado correctamente.");
        }
        return ResponseEntity.ok("Error: no se pudo eliminar el marca.");
    }

}
