package com.ferjava.controllers;

import com.ferjava.dao.UsuarioDao;
import com.ferjava.dto.LoginUsuarioDTO;
import com.ferjava.models.UserEntity;
import com.ferjava.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestBody LoginUsuarioDTO login){
        UserEntity userEntity = this.usuarioDao.verificarCredenciales(login);
        if(!isNull(userEntity)){
            String token = jwtUtil.create(String.valueOf(userEntity.getId()), userEntity.getEmail());
            return token+"  -  "+login.getEmail();
        }
        return "Acceso denegado";
    }

}
