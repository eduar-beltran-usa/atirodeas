package com.atirodeas.repository;

import com.atirodeas.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByEmailAndPassword(String email,String password);
    //Optional<User> findByName(String name);
}