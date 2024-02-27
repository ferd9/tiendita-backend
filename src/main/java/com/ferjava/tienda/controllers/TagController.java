package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateTagDTO;
import com.ferjava.tienda.dto.UpdateTagDTO;
import com.ferjava.tienda.models.TagEntity;
import com.ferjava.tienda.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tag")
public class TagController {


    @Autowired
    private TagRepository tagRepository;
    @PostMapping("/crear")
    public ResponseEntity <?> crearTag(@RequestBody CreateTagDTO createTagDTO){

        TagEntity tag = new TagEntity(createTagDTO.getNombre());
       this.tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @PostMapping("/crear/muchos")
    public ResponseEntity <?> crearTags(@RequestBody List<CreateTagDTO> listCreateTag){

        List<TagEntity> listTags = new ArrayList<>();
        listCreateTag.forEach(tag -> {
            listTags.add(new TagEntity(tag.getNombre()));
        });

        this.tagRepository.saveAll(listTags);
        return ResponseEntity.ok(listTags);
    }

    @PutMapping("/actualizar")
    public ResponseEntity <?> actualizarTag(@RequestBody UpdateTagDTO updateTagDTO){
        TagEntity tag = new TagEntity(updateTagDTO.getId(),updateTagDTO.getNombre());
        this.tagRepository.save(tag);
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/listar")
    public ResponseEntity <?> listarTags(){
        return ResponseEntity.ok(this.tagRepository.findAll());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity <?> buscarTagsPorId(@PathVariable long id){
        Optional<TagEntity> optionalTag = this.tagRepository.findById(id);
        if(optionalTag.isPresent())
        {
            return ResponseEntity.ok(optionalTag.get());
        }
        return ResponseEntity.ok("Tag inexistente");
    }

    @GetMapping("/buscar/nombre/{nombre}")
    public ResponseEntity <?> actualizarTagsPorNombre(@PathVariable String nombre){
        Optional<TagEntity> tagEntity = this.tagRepository.findByNombre(nombre);

        if(tagEntity.isPresent())
        {
            return ResponseEntity.ok(tagEntity.get());
        }
        return ResponseEntity.ok("Tag inexistente");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity <?> eliminarTag(@PathVariable long id){
        this.tagRepository.deleteById(id);
        Optional<TagEntity> tag = this.tagRepository.findById(id);

        if(tag.isPresent()){
            ResponseEntity.ok("El tag fue eliminado correctamente.");
        }
        return ResponseEntity.ok("Error: no se pudo eliminar el tag.");
    }
}
