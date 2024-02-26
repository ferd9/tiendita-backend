package com.ferjava.tienda.dao;

import com.ferjava.tienda.dto.LoginUsuarioDTO;
import com.ferjava.tienda.models.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioDao {

    public List<UserEntity> getListUsuarios();

    public UserEntity deleteUsuario(Long id);

    public UserEntity findUsuario(Long id);

    public UserEntity updateUsuario(UserEntity userEntity);

    public UserEntity createUsuario(UserEntity userEntity);

    public UserEntity verificarCredenciales(LoginUsuarioDTO login);

}
