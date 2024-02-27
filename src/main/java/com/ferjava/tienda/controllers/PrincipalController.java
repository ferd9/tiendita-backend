package com.ferjava.tienda.controllers;

import com.ferjava.tienda.dto.CreateUserDTO;
import com.ferjava.tienda.models.ERole;
import com.ferjava.tienda.models.RoleEntity;
import com.ferjava.tienda.models.UserEntity;
import com.ferjava.tienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController()
public class PrincipalController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @PostMapping(value = "/create-user")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){

        Set<RoleEntity> role = createUserDTO.getRoles().stream()
                .map(rol -> {
                    return new RoleEntity(rol.getRole());
                })
                .collect(Collectors.toSet());


        UserEntity userEntity =  new UserEntity(
                createUserDTO.getNombre(),
                createUserDTO.getApellido(),
                createUserDTO.getEmail(),
                createUserDTO.getUsername(),
                createUserDTO.getTelefono(),
                this.passwordEncoder.encode(createUserDTO.getPassword()),
                role
        );
      userEntity  = this.userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("delete-user")
    public String deleteUser(@RequestParam String id){
        this.userRepository.deleteById(Long.parseLong(id));
        return "Usuario Eliminado.";
    }

    @GetMapping("/hello")
    public String hello(){
        return "holaa usuario.";
    }
}
