package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateProveedorDTO;
import com.ferjava.tienda.models.ProveedorEntity;
import com.ferjava.tienda.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @PostMapping("/crear")
    public ResponseEntity<?> createProveedor(@RequestBody CreateProveedorDTO createProveedorDTO){
        ProveedorEntity proveedorEntity = new ProveedorEntity();
                        proveedorEntity.setNombre(createProveedorDTO.getNombre());
                        proveedorEntity.setDireccion(createProveedorDTO.getDireccion());
                        proveedorEntity.setEmail(createProveedorDTO.getEmail());
                        proveedorEntity.setTelefono(createProveedorDTO.getTelefono());
                        proveedorEntity.setRuc(createProveedorDTO.getRuc());
                        proveedorEntity.setRubros(createProveedorDTO.getRubros());
        this.proveedorRepository.save(proveedorEntity);
        return ResponseEntity.ok(proveedorEntity);
    }

    @PostMapping("/crear/muchos")
    public ResponseEntity<?> createProveedores(@RequestBody List<CreateProveedorDTO> createProveedorDTO){
        List<ProveedorEntity> proveedorEntityList = new ArrayList<>();

        createProveedorDTO.forEach(proveedorDTO -> {

            ProveedorEntity proveedorEntity = new ProveedorEntity();
            proveedorEntity.setNombre(proveedorDTO.getNombre());
            proveedorEntity.setDireccion(proveedorDTO.getDireccion());
            proveedorEntity.setEmail(proveedorDTO.getEmail());
            proveedorEntity.setTelefono(proveedorDTO.getTelefono());
            proveedorEntity.setRuc(proveedorDTO.getRuc());
            proveedorEntity.setRubros(proveedorDTO.getRubros());

            proveedorEntityList.add(proveedorEntity);
        });

        this.proveedorRepository.saveAll(proveedorEntityList);
        return ResponseEntity.ok(proveedorEntityList);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarProveedores(){
        return ResponseEntity.ok(this.proveedorRepository.findAll());
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> updateProveedor(@RequestBody CreateProveedorDTO createProveedorDTO){

        ProveedorEntity proveedorEntity = new ProveedorEntity();
                        proveedorEntity.setId(createProveedorDTO.getId());
                        proveedorEntity.setNombre(createProveedorDTO.getNombre());
                        proveedorEntity.setDireccion(createProveedorDTO.getDireccion());
                        proveedorEntity.setEmail(createProveedorDTO.getEmail());
                        proveedorEntity.setTelefono(createProveedorDTO.getTelefono());
                        proveedorEntity.setRuc(createProveedorDTO.getRuc());
                        proveedorEntity.setRubros(createProveedorDTO.getRubros());

        this.proveedorRepository.save(proveedorEntity);

        return ResponseEntity.ok(proveedorEntity);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> searchProveedorById(@PathVariable Long id){
        Optional<ProveedorEntity> optionalProveedorEntity = this.proveedorRepository.findById(id);

        if(optionalProveedorEntity.isPresent()){
            return ResponseEntity.ok(optionalProveedorEntity.get());
        }
        return ResponseEntity.ok("proveedor no encontrado");
    }

    @GetMapping("buscar/nombre")
    public ResponseEntity<?> searchProveedorByNombre(@RequestParam(name = "q") String nombre){
        Optional<ProveedorEntity> optionalProveedorEntity = this.proveedorRepository.findByNombre(nombre);

        if(optionalProveedorEntity.isPresent()){
            return ResponseEntity.ok(optionalProveedorEntity.get());
        }
        return ResponseEntity.ok("proveedor no encontrado");
    }

    @GetMapping("buscar/ruc")
    public ResponseEntity<?> searchProveedorByRuc(@RequestParam(name = "q") String ruc){
        Optional<ProveedorEntity> optionalProveedorEntity = this.proveedorRepository.findByRuc(ruc);

        if(optionalProveedorEntity.isPresent()){
            return ResponseEntity.ok(optionalProveedorEntity.get());
        }
        return ResponseEntity.ok("proveedor no encontrado");
    }

    @GetMapping("buscar/email")
    public ResponseEntity<?> searchProveedorByEmail(@RequestParam(name="q") String email) /*throws UnsupportedEncodingException*/ {
        //String decodeEmail = URLDecoder.decode(email, StandardCharsets.UTF_8.name());
        Optional<ProveedorEntity> optionalProveedorEntity = this.proveedorRepository.findByEmail(email);

        if(optionalProveedorEntity.isPresent()){
            return ResponseEntity.ok(optionalProveedorEntity.get());
        }
        return ResponseEntity.ok("proveedor no encontrado");
    }


}
