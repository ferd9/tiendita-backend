package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateRubroDTO;
import com.ferjava.tienda.dto.UpdateRubroDTO;
import com.ferjava.tienda.models.RubroEntity;
import com.ferjava.tienda.repositories.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rubro")
public class RubroController {

    @Autowired
    private RubroRepository rubroRepository;
    @PostMapping("/crear")
    public ResponseEntity<?> crearRubro(@RequestBody CreateRubroDTO createRubroDTO){

        RubroEntity rubro = new RubroEntity(createRubroDTO.getNombre());
        this.rubroRepository.save(rubro);
        return ResponseEntity.ok(rubro);
    }

    @PostMapping("/crear/muchos")
    public ResponseEntity <?> crearRubros(@RequestBody List<CreateRubroDTO> listCreateRubroDTO){

        List<RubroEntity> listRubros = new ArrayList<>();
        listCreateRubroDTO.forEach(rubro -> {
            listRubros.add(new RubroEntity(rubro.getNombre()));
        });

        this.rubroRepository.saveAll(listRubros);
        return ResponseEntity.ok(listRubros);
    }

    @PutMapping("/actualizar")
    public ResponseEntity <?> actualizarRubro(@RequestBody UpdateRubroDTO updateRubroDTO){
        RubroEntity tag = new RubroEntity(updateRubroDTO.getId(),updateRubroDTO.getNombre());
        this.rubroRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/listar")
    public ResponseEntity <?> listarRubros(){
        return ResponseEntity.ok(this.rubroRepository.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity <?> buscarRubroPorId(@PathVariable long id){
        Optional<RubroEntity> optionalRubro = this.rubroRepository.findById(id);
        if(optionalRubro.isPresent())
        {
            return ResponseEntity.ok(optionalRubro.get());
        }
        return ResponseEntity.ok("Rubro inexistente");
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity <?> actualizarRubroPorNombre(@PathVariable String nombre){
        Optional<RubroEntity> rubroEntity = this.rubroRepository.findByNombre(nombre);

        if(rubroEntity.isPresent())
        {
            return ResponseEntity.ok(rubroEntity.get());
        }
        return ResponseEntity.ok("rubro inexistente");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity <?> eliminarRubro(@PathVariable long id){
        this.rubroRepository.deleteById(id);
        Optional<RubroEntity> rubro = this.rubroRepository.findById(id);

        if(rubro.isPresent()){
            ResponseEntity.ok("El rubro fue eliminado correctamente.");
        }
        return ResponseEntity.ok("Error: no se pudo eliminar el rubro.");
    }
}
