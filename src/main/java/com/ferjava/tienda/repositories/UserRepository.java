package com.ferjava.tienda.repositories;

import com.ferjava.tienda.models.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    /**
     * jpa genera una consulta basada en el nombre del metodo
     * despues del prefijo 'findBy'. por ejemplo jpa
     * generaria 'select * from user where username = ?'
     * el signo de interrogacion es el valor que pasamos como parametro al metodo.
     * @param username
     * @return
     */
    Optional<UserEntity> findByUsername(String username);

    @Query("select u from UserEntity u where u.username = ?1")
    Optional<UserEntity> getName(String username);
}
