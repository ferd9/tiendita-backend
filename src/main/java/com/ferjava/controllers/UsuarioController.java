package com.ferjava.controllers;

import com.ferjava.dao.UsuarioDao;
import com.ferjava.models.UserEntity;

import com.ferjava.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Objects.isNull;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value = "usuario/{id}")
    public UserEntity getUsuario(@PathVariable Long id){
        return this.usuarioDao.findUsuario(id);
    }

    @RequestMapping(value = "crear", method = RequestMethod.POST)
    public String crearUsuario(@RequestBody UserEntity userEntity){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String encryptedPassword = argon2.hash(2,1024,1, userEntity.getPassword());
        userEntity.setPassword(encryptedPassword);
        this.usuarioDao.createUsuario(userEntity);
        return "usuario grabado";
    }

    @RequestMapping(value = "actualizar", method = RequestMethod.POST)
    public String actualizarUsuario(@RequestBody UserEntity userEntity){
        this.usuarioDao.updateUsuario(userEntity);
        return "usuario actualizado";
    }

    @RequestMapping(value = "usuarios")
    public List<UserEntity> getUsuarios(@RequestHeader(value="Authorization") String token){

        String[] nobearer = token.split(" ");

        String tokenValid = this.jwtUtil.getKey(nobearer[1].trim());

        if(!isNull(tokenValid)){
            return usuarioDao.getListUsuarios();
        }
        return null;
    }

    @RequestMapping(value = "usuario/{id}", method = RequestMethod.DELETE)
    public String deleteUsuario(@PathVariable Long id){
        this.usuarioDao.deleteUsuario(id);
        return "Usuario eliminado";
    }

}
