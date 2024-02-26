package com.ferjava.tienda.dao.impl;

import com.ferjava.tienda.dao.UsuarioDao;
import com.ferjava.tienda.dto.LoginUsuarioDTO;
import com.ferjava.tienda.models.UserEntity;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.util.Objects.isNull;


@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<UserEntity> getListUsuarios() {
        return this.entityManager.createQuery("FROM UserEntity", UserEntity.class).getResultList();
    }



    @Override
    public UserEntity deleteUsuario(Long id) {
        UserEntity usr = this.entityManager.find(UserEntity.class,id);
        if(!isNull(usr)){
            this.entityManager.remove(usr);
        }

        return usr;
    }

    @Override
    public UserEntity findUsuario(Long id) {
        return this.entityManager.find(UserEntity.class,id);
    }

    @Override
    public UserEntity updateUsuario(UserEntity userEntity) {
        return this.entityManager.merge(userEntity);
    }

    @Override
    public UserEntity createUsuario(UserEntity userEntity) {
       this.entityManager.persist(userEntity);
       return null;
    }

    @Override
    public UserEntity verificarCredenciales(LoginUsuarioDTO login) {
        String query = "FROM UserEntity where email = :email";
        List<UserEntity> loginUser = this.entityManager.createQuery(query)
                .setParameter("email",login.getEmail())
                .getResultList();
        if(isNull(loginUser)){
            return loginUser.get(0);
        } else if (loginUser.size() == 0) {
            return null;
        }else{
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            if(argon2.verify(loginUser.get(0).getPassword(), login.getPassword()))
            {
                return loginUser.get(0);
            }
            return null;
        }
    }

}
