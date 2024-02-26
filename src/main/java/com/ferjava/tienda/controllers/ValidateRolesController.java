package com.ferjava.tienda.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateRolesController {

    @GetMapping("/rol-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin(){
        return "Hola Admin";
    }
    @GetMapping("/rol-user")
    @PreAuthorize("hasRole('USER')")
    public String accessUser(){
        return "Hola user";
    }
    @GetMapping("/rol-invitado")
    @PreAuthorize("hasRole('INVITED')")
    public String accessInvitado(){
        return "Hola Invitado";
    }
}
